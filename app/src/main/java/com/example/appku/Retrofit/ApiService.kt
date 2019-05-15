package com.example.appku.Retrofit

import com.example.appku.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @get:GET("photos")
    val photos:Observable<List<Post>>




}