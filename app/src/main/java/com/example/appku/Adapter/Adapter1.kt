package com.example.appku.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.appku.Model.Post
import com.example.appku.R

class Adapter1(internal var context: Context, internal var postlist:MutableList<Post>)
    :RecyclerView.Adapter<VHoleder1>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VHoleder1 {
     var rowlayoute=LayoutInflater.from(p0.context)
         .inflate(R.layout.rownotif,p0,false)
        return  VHoleder1(rowlayoute)


    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    override fun onBindViewHolder(p0: VHoleder1, p1: Int) {

        p0.cometcount.text=postlist[p1].albumId.toString()
        p0.likecount.text=postlist[p1].id.toString()
        p0.post.text=postlist[p1].title

        Glide
            .with(context)
            .load(postlist[p1].url)
            .apply(RequestOptions.circleCropTransform())
            .into(p0.imageprofil)
        Glide
            .with(context)
            .load(postlist[p1].thumbnailUrl)
            .into(p0.imagepost)

        Glide
            .with(context)
            .load(R.drawable.like)
            .into(p0.btlike)
        Glide
            .with(context)
            .load(R.drawable.coment)
            .into(p0.btcomen)


    }


}