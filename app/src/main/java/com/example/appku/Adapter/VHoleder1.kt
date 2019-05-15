package com.example.appku.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.rownotif.view.*

class VHoleder1(item1:View):RecyclerView.ViewHolder(item1) {

    val likecount   =   itemView.like
    val cometcount  =   itemView.Coment
    val username    =   itemView.NameUser
    val imageprofil =   itemView.imageprofil
    val imagepost   =   itemView.ImagePost
    val post        =   itemView.posttext

    val btlike   =   itemView.btlik
    val btcomen        =   itemView.BtComent

}