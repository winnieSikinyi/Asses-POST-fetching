package com.example.apkfetch.Repository

import com.example.apkfetch.apis.ApiClient
import com.example.apkfetch.apis.ApiInterface
import com.example.apkfetch.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {
   val apiClient = ApiClient.buildClient(ApiInterface::class.java)
   suspend fun getPosts(): Response<List<Post>>{
      return withContext(Dispatchers.IO){
         apiClient.getPosts()
      }
   }

}