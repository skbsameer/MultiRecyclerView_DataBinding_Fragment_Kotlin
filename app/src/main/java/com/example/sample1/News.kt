package com.example.sample1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//https://economictimes.indiatimes.com//js_feed/newslisting_topnewsfeed/48466338.cms?feedtype=etjson&andver=429&platform=android

interface News {

    @GET( "48466338.cms?feedtype=etjson&andver=429&platform=android"
    )
    fun getNews() : Call<NewsApp>
}

object Pn{
    val newsInstance: News
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://economictimes.indiatimes.com//js_feed/newslisting_topnewsfeed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(News::class.java)
    }
}