package com.example.retrofit.service;

import android.database.Observable;

import com.example.retrofit.model.CryptoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CryptoAPI {
    //GET, POST, UPDATE, DELETE
    @GET("/atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    Call<List<CryptoModel>> getData();
    //Observable<List<CryptoModel>> getData();
}
