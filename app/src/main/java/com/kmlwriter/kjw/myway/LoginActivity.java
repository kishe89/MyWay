package com.kmlwriter.kjw.myway;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
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
import com.kmlwriter.kjw.myway.model.rest_api.v1.UsersAPI;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import android.net.Uri;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.Profile.getCurrentProfile;

public class LoginActivity extends Activity{

    @Nullable @BindView(R.id.login_btn_facebook) Button login_btn_facebook;
    @Nullable @BindView(R.id.image) ImageView image;
    private CallbackManager callbackManager;
    private Profile profile;
    private Activity self;
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
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                if (error instanceof FacebookAuthorizationException) {
                    if (AccessToken.getCurrentAccessToken() != null) {
                        LoginManager.getInstance().logOut();
                    }
                }
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
                            new UrlConvertToFileTask(self, profile, url, new ConvertListener() {
                                @Override
                                public void ConvertSuccess(Call<User> call) {
                                    call.enqueue(new Callback<User>() {
                                        @Override
                                        public void onResponse(Call<User> call, Response<User> response) {
                                            Log.e("signup",response.toString());
                                        }

                                        @Override
                                        public void onFailure(Call<User> call, Throwable t) {
                                            Log.e("signup",t.toString());
                                        }
                                    });
                                }
                            }).execute();

                        } catch (JSONException e){
                            e.printStackTrace();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).executeAsync();
    }

    @Optional @OnClick(R.id.login_btn_facebook)
    protected void loginFacebook(){
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
