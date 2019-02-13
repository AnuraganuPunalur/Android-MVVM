package com.example.anuraganu.mymvvm.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.anuraganu.mymvvm.R
import com.example.anuraganu.mymvvm.databinding.RecyclerHeroDataBinding
import com.example.anuraganu.mymvvm.model.HeroModel
import kotlinx.android.synthetic.main.activity_main.view.*

class HeroAdapter(var context : Context,var heroList: List<HeroModel>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val heroDataBinding = RecyclerHeroDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(heroDataBinding)
    }

    override fun getItemCount(): Int {

       return heroList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setBinding(heroList[position])
    }


    class ViewHolder(var recyclerHeroDataBinding: RecyclerHeroDataBinding) : RecyclerView.ViewHolder(recyclerHeroDataBinding.root) {

        fun setBinding(heroModel: HeroModel){

            Glide.with(recyclerHeroDataBinding.ivHeroImage.context).
                load(heroModel.getImageurl()).into(recyclerHeroDataBinding.ivHeroImage)

            recyclerHeroDataBinding.tvHeroName.text = heroModel.getName()
            recyclerHeroDataBinding.executePendingBindings()
        }
    }
}