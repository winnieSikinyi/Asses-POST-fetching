package com.example.apkfetch.apis

import com.example.apkfetch.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}