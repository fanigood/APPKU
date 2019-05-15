package com.example.appku

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.appku.Adapter.Adapter1
import com.example.appku.Model.Post
import com.example.appku.Retrofit.ApiService
import com.example.appku.Retrofit.RetrofitClient
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_fragman_post.*
import kotlinx.android.synthetic.main.fragment_fragment_get.*
import kotlinx.android.synthetic.main.rownotif.*
import retrofit2.Retrofit

class FragmentPost:Fragment() {
   internal lateinit var JsonApi:ApiService
    internal var compositeDisposable= CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragman_post, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit= RetrofitClient.instace
        JsonApi= retrofit.create(ApiService::class.java)

        recypost.setHasFixedSize(true)
        recypost.layoutManager=LinearLayoutManager(activity)
        FetchPost()



    }

    private fun FetchPost(){
        compositeDisposable.add(JsonApi.photos
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

               photos->displayData(photos)

            },{

                Toast.makeText(activity,"Sorry You Signal Error",Toast.LENGTH_LONG).show()

            })


        )

    }

    private fun displayData(photos: List<Post>?) {

        val adapter=Adapter1(this!!.activity!!,(photos as MutableList<Post>?)!!)
        recypost.adapter=adapter
    }


}