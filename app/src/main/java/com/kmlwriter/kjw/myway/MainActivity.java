package com.kmlwriter.kjw.myway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

import static com.facebook.Profile.getCurrentProfile;

public class MainActivity extends Activity {

    @Nullable @BindView(R.id.login_btn_facebook) Button login_btn_facebook;
    @Nullable @BindView(R.id.image) ImageView image;
    private CallbackManager callbackManager;
    private Profile profile;
    private Activity self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Log.d("MainActivity","Success");
                AccessToken loginResultAccessToken = loginResult.getAccessToken();
                profile = getCurrentProfile();

                Log.d("MainActivity",profile.getName());
                StringBuilder graphPath = new StringBuilder();
                graphPath.append("/").append(loginResultAccessToken.getUserId()).append("/picture");
//                graphPath.append("/").append("me").append("/picture");
                Bundle parameters = new Bundle();
//                parameters.putString("fields","picture.width(150).height(150)");
                parameters.putInt("width",150);
                parameters.putInt("height",150);
                parameters.putBoolean("redirect", false);
                new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        graphPath.toString(),
                        parameters,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                Log.e("profile",response.getJSONObject().toString());
                                JSONObject data = response.getJSONObject();
                                try {
                                    String profile_url = data.getJSONObject("data").getString("url");
                                    Glide.with(self).load(profile_url).into(image);
                                } catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                ).executeAsync();
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

    @Optional @OnClick(R.id.login_btn_facebook)
    protected void loginFacebook(){
        Log.e("click","click");
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
