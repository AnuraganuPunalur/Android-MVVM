package com.example.anuraganu.mymvvm.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.anuraganu.mymvvm.api.Api
import com.example.anuraganu.mymvvm.model.HeroModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.databinding.adapters.NumberPickerBindingAdapter.setValue
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class HeroViewModel : ViewModel() {

    private lateinit var heroMutableList : MutableLiveData<List<HeroModel>>

    fun getHeroList() : LiveData<List<HeroModel>>{

        heroMutableList = MutableLiveData()

        Api.getInstance().getHero().enqueue(object : Callback<List<HeroModel>>{

            override fun onResponse(call: Call<List<HeroModel>>, response: Response<List<HeroModel>>) {

                heroMutableList.value = response.body()
            }

            override fun onFailure(call: Call<List<HeroModel>>, t: Throwable) {


            }
        })

        return heroMutableList
    }


}


