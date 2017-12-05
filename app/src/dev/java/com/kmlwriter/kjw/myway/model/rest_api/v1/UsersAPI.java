package com.kmlwriter.kjw.myway.model.rest_api.v1;

import com.kmlwriter.kjw.myway.Const.ConstString;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Friend;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Friend_Response;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Profile;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.User;

import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kjw on 2017. 12. 5..
 */

public interface UsersAPI {
    @GET(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH)
    Call<User> MyInformationSearch(@Header("x-access-token") String AccessToken,
                                   @Query("Nick") String Nick,
                                   @Query("App") String App,
                                   @Query("AppId") String AppId);
    @Multipart
    @POST(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH)
    Call<User> SignUp(@Part("Nick") RequestBody Nick,
                      @Part("App") RequestBody App,
                      @Part("AppId") RequestBody AppId,
                      @Part MultipartBody.Part Profile);

    @GET(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH+ConstString.PROFILE_PATH)
    Call<InputStream> MyProfileSearch(@Header("x-access-token") String AccessToken,
                                      @Query("Nick") String Nick,
                                      @Query("App") String App,
                                      @Query("AppId") String AppId);

    @POST(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH+ConstString.PROFILE_PATH)
    Call<Profile> MyProfileUpload(@Header("x-access-token") String AccessToken,
                                  @Part("Nick") RequestBody Nick,
                                  @Part("App") RequestBody App,
                                  @Part("AppId") RequestBody AppId,
                                  @Part MultipartBody.Part Profile);

    @GET(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH+ConstString.FRIENDS_PATH)
    Call<ArrayList<Friend>> UserListSearch(@Header("x-access-token") String AccessToken,
                                           @Path("Nick") String Nick,
                                           @Path("App") String App,
                                           @Path("AppId") String AppId,
                                           @Query("page_no") int page_no,
                                           @Query("FriendNick") String FriendNick);

    @POST(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH+ConstString.FRIENDS_PATH)
    Call<Friend_Response> FriendApplicationAccept(@Header("x-access-token") String AccessToken,
                                                  @Path("Nick") String Nick,
                                                  @Path("App") String App,
                                                  @Path("AppId") String AppId,
                                                  @Query("_id") String _id);

    @PUT(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH+ConstString.FRIENDS_PATH)
    Call<Friend_Response> FriendApplication(@Header("x-access-token") String AccessToken,
                                            @Path("Nick") String Nick,
                                            @Path("App") String App,
                                            @Path("AppId") String AppId,
                                            @Query("_id") String _id);

    @DELETE(ConstString.BASE_V1_PATH+ConstString.BASE_USER_PATH+ConstString.FRIENDS_PATH)
    Call<Friend_Response> FriendRemove(@Header("x-access-token") String AccessToken,
                                            @Path("Nick") String Nick,
                                            @Path("App") String App,
                                            @Path("AppId") String AppId,
                                            @Query("_id") String _id);

}
