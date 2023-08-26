package com.example.apkfetch.apis

import com.example.apkfetch.model.Post

interface ApiInterface {

    @GET("/posts")
    fun getPosts(): Response <List<Post>>
}