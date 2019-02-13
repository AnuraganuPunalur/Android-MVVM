package com.example.anuraganu.mymvvm.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.anuraganu.mymvvm.R
import com.example.anuraganu.mymvvm.adapter.HeroAdapter
import com.example.anuraganu.mymvvm.databinding.ActivityMainBinding
import com.example.anuraganu.mymvvm.model.HeroModel
import com.example.anuraganu.mymvvm.viewmodel.HeroViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var heroViewModel: HeroViewModel
    private lateinit var heroAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        activityMainBinding.heroRecycler.layoutManager = linearLayoutManager


        heroViewModel = ViewModelProviders.of(this).get(HeroViewModel::class.java)
        heroViewModel.getHeroList().observe(this,object : Observer<List<HeroModel>>{

            override fun onChanged(heroList: List<HeroModel>?) {
                if (heroList != null) {
                    heroAdapter = HeroAdapter(this@MainActivity, heroList)
                    activityMainBinding.heroRecycler.adapter = heroAdapter
                    heroAdapter.notifyDataSetChanged()
                }else{


                }
            }

        })
    }



}
