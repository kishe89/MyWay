package com.kmlwriter.kjw.myway.model.rest_api.v1;

import com.kmlwriter.kjw.myway.Const.ConstString;
import com.kmlwriter.kjw.myway.model.rest_api.v1.model.Article;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by kjw on 2017. 12. 5..
 */

public interface ArticlesAPI {

    @GET(ConstString.BASE_V1_PATH+ConstString.BASE_ARTICLE_PATH)
    Call<Article> ArticleSearch(@Header("x-access-token") String AccessToken,
                                @Query("Nick") String Nick,
                                @Query("App") String App,
                                @Query("AppId") String AppId,
                                @Query("page_no") int page_no);

    @Multipart
    @POST(ConstString.BASE_V1_PATH+ConstString.BASE_ARTICLE_PATH)
    Call<Article> ArticleSave(@Header("x-access-token") String AccessToken,
                              @Part("Nick") RequestBody Nick,
                              @Part("App") RequestBody App,
                              @Part("AppId") RequestBody AppId,
                              @Part("Contents") RequestBody Contents,
                              @Part("Publish_range") RequestBody Publish_range,
                              @Part("articleItems") RequestBody articleItems,
                              @Part("photos") MultipartBody.Part photos,
                              @Part("kml") MultipartBody.Part kml);
}
