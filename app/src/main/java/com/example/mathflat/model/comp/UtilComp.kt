package com.example.mathflat.model.comp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mathflat.R

class UtilComp {
    companion object {
        @JvmStatic
        @BindingAdapter("heartImg")
        fun setHeartImg(iv:ImageView, checkBool : Boolean){
            if(checkBool) Glide.with(iv.context).load( iv.context.getDrawable(R.drawable.iv_heart_favorite) ).into(iv)
            else Glide.with(iv.context).load( iv.context.getDrawable(R.drawable.iv_heart_un_favorite) ).into(iv)
        }
        @JvmStatic
        @BindingAdapter("probImg")
        fun setProbImg(iv:ImageView, probUrl : String ){
            Glide.with(iv.context).load( probUrl ).fitCenter().into(iv)
        }
    }
}