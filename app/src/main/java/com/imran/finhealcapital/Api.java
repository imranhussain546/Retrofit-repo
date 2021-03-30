package com.imran.finhealcapital;

import com.imran.finhealcapital.Modelclass.Setdata;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api
{

    @POST("T2SetupGuide")
    Call<Setdata> getData(
            @Header("Authorization") String Bearer
    );
}
