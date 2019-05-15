package com.example.appku.Retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var OurInstance:Retrofit?= null
    private var Url="https://jsonplaceholder.typicode.com/"
   val instace:Retrofit
    get() {
        if (OurInstance == null){
            OurInstance= Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()



        }
        return OurInstance!!


    }





}