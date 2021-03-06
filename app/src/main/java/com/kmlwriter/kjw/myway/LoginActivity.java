package com.kmlwriter.kjw.myway;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.kmlwriter.kjw.myway.const_string.ConstString;
import com.kmlwriter.kjw.myway.const_string.ResponseCode;
import com.kmlwriter.kjw.myway.model.realmModel.RealmUser;
import com.kmlwriter.kjw.myway.model.rest_api.v1.UsersAPI;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import com.kmlwriter.kjw.myway.realm.RealmConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.Profile.getCurrentProfile;

public class LoginActivity extends Activity{

    @Nullable @BindView(R.id.login_btn_facebook) Button login_btn_facebook;
    @Nullable @BindView(R.id.login_btn_kakaotalk) Button login_btn_kakaotalk;
    @Nullable @BindView(R.id.image) ImageView image;
    private CallbackManager callbackManager;
    private Profile profile;
    private Activity self;
    private UrlConvertToFileTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        self = this;
        FacebookInitialize();
    }

    private void FacebookInitialize() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("LoginActivity","Success");
                AccessToken loginResultAccessToken = loginResult.getAccessToken();
                profile = getCurrentProfile();
                runGraphAPI(loginResultAccessToken);

            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), getApplicationContext()
                        .getResources()
                        .getString(R.string.Facebook_login_cancel), Toast.LENGTH_LONG)
                        .show();
                if (AccessToken.getCurrentAccessToken() != null) {
                    LoginManager.getInstance().logOut();
                }
                setLoginButtonClickable();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                if (error instanceof FacebookAuthorizationException) {
                    if (AccessToken.getCurrentAccessToken() != null) {
                        LoginManager.getInstance().logOut();
                    }
                }
                setLoginButtonClickable();
            }
        });
    }

    private void runGraphAPI(AccessToken loginResultAccessToken) {

        Log.d("LoginActivity",profile.getName());
        StringBuilder graphPath = new StringBuilder();
        graphPath.append("/").append(loginResultAccessToken.getUserId()).append("/picture");
        Bundle parameters = new Bundle();
        parameters.putInt("width",150);
        parameters.putInt("height",150);
        parameters.putBoolean("redirect", false);
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                graphPath.toString(),
                parameters,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public UsersAPI UserApi;

                    public void onCompleted(GraphResponse response) {
                        Log.e("profile",response.getJSONObject().toString());
                        JSONObject data = response.getJSONObject();
                        try {
                            String profile_url_string = data.getJSONObject("data").getString("url");
                            URL url = new URL(profile_url_string);
                            task = new UrlConvertToFileTask(self, profile, url, new ConvertListener() {
                                @Override
                                public void ConvertSuccess(Call<User> call) {
                                    call.enqueue(new Callback<User>() {
                                        @Override
                                        public void onResponse(Call<User> call, Response<User> response) {
                                            if (response.isSuccessful()) {
                                                Toast.makeText(self, "성공" + response.code(), Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(self, ContainerActivity.class);
                                                startActivity(intent);
                                                self.finish();
                                            }else if(response.code() == ResponseCode.DUPLICATE_CODE.getCode()){
                                                UsersAPI usersApi = ServiceGenerator.createRetrofitService(UsersAPI.class);
                                                usersApi.LoggedIn(profile.getName(), ConstString.Authorization_FACEBOOK, profile.getId())
                                                        .enqueue(new Callback<User>() {
                                                    @Override
                                                    public void onResponse(Call<User> call, Response<User> response) {
                                                        User user = response.body();
                                                        RealmUser realmUser = new RealmUser().set__v(user.get__v())
                                                                .set_id(user.get_id())
                                                                .setAccessToken(user.getAccessToken())
                                                                .setAgree_Wait_Friends(user.getAgree_Wait_Friends(1))
                                                                .setApp(user.getApp())
                                                                .setAppId(user.getAppId())
                                                                .setDecryptValuel(user.getDecryptValuel())
                                                                .setFriends(user.getFriends(1))
                                                                .setNick(user.getNick())
                                                                .setProfile(user.getProfile())
                                                                .setUpload_Article(user.getUpload_Article(1));

                                                        Intent intent = new Intent(self, ContainerActivity.class);
                                                        Realm realm = Realm.getInstance(RealmConfig.newInstance());
                                                        try{
                                                            realm.beginTransaction();
                                                            realm.copyToRealm(realmUser);
                                                            realm.commitTransaction();
                                                            startActivity(intent);
                                                            self.finish();
                                                        }catch (Exception e){
                                                            Toast.makeText(self, getResources().getString(R.string.RealmSaveException),Toast.LENGTH_SHORT).show();
                                                            Log.e(ConstString.REALM_EXCEPTION_TAG,e.toString());
                                                            self.finish();
                                                        }finally {
                                                            realm.close();
                                                        }
                                                    }

                                                    @Override
                                                    public void onFailure(Call<User> call, Throwable t) {
                                                        setLoginButtonClickable();
                                                        Toast.makeText(self, self.getResources().getString(R.string.request_fail_internal_string), Toast.LENGTH_SHORT).show();
                                                    }
                                                });


                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<User> call, Throwable t) {
                                            setLoginButtonClickable();
                                            Toast.makeText(self, self.getResources().getString(R.string.request_fail_internal_string), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            });
                            task.execute();

                        } catch (JSONException e){
                            e.printStackTrace();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).executeAsync();
    }

    @Optional @OnClick(R.id.login_btn_facebook)
    protected void loginFacebook(){
        setLoginButtonClickable();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList(ConstString.FACEBOOK_PUBLIC_PROFILE_PERMISSION));
    }
    @Optional @OnClick(R.id.login_btn_kakaotalk)
    protected void loginKakaotalk(){
        setLoginButtonClickable();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    protected void setLoginButtonClickable(){
        if(login_btn_facebook.isClickable()){
            login_btn_facebook.setClickable(false);
            login_btn_kakaotalk.setClickable(false);
        }else{
            login_btn_facebook.setClickable(true);
            login_btn_kakaotalk.setClickable(false);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(task!=null){
            if(task.waitDialog_isShowing()){
                task.waitDialog_dismiss();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(task!=null){
            if(task.waitDialog_isShowing()){
                task.waitDialog_dismiss();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(task!=null){
            if(task.waitDialog_isShowing()){
                task.waitDialog_dismiss();
            }
        }
    }
}
