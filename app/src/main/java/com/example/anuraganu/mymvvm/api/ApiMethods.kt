package com.example.anuraganu.mymvvm.api

import com.example.anuraganu.mymvvm.model.HeroModel
import com.example.anuraganu.mymvvm.viewmodel.HeroViewModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethods {

    @GET(ApiEndpoints.BASE_URL)
    fun getHero() : Call<List<HeroModel>>

}