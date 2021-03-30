package com.imran.finhealcapital;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL="http://3.23.59.87/api/";
    private static RetrofitClient mInstance;
    private static Retrofit retrofit;
//    private static OkHttpClient okHttpClient;
//    private static int REQUEST_TIMEOUT = 30;



    private static  Retrofit getInstance() {
        if (retrofit == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                    .connectTimeout(3, TimeUnit.MINUTES)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS);

            httpClient.addInterceptor(logging);

//            httpClient.addInterceptor(chain -> {
//                Request original = chain.request();
//                Request.Builder requestBuilder = original.newBuilder()
//                        .addHeader("Accept", "application/json")
//                        .addHeader("Content-Type", "application/json")
//                        .addHeader("Authorization", "bearer " +token);
//
//                Request request = requestBuilder.build();
//                return chain.proceed(request);
//            });

            retrofit = new Retrofit.Builder()
                    .client(httpClient.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }



    public static Api getApi()
    {
        return getInstance().create(Api.class);
    }
}
