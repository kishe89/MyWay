package com.kmlwriter.kjw.myway;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kmlwriter.kjw.myway.Const.ConstString;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {

    public static final String API_BASE_URL = ConstString.BASE_URL;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson));

    public static <S> S createRetrofitService( Class<S> serviceClass ) {
        Retrofit retrofit;

        builder.client(httpClient.build());
        retrofit = builder.build();

        return retrofit.create(serviceClass);
    }
}