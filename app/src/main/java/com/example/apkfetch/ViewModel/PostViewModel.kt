package com.example.apkfetch.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.apkfetch.model.Post
import com.example.apkfetch.Repository.PostRepository
import kotlinx.coroutines.launch




class PostsViewModel:ViewModel() {
    val postsRepo= PostsRepository()
    var postLiveData= MutableLiveData<List<Posts>>()
    var errorLiveData=MutableLiveData<String>()
    fun fetchPosts(){
        viewModelScope.launch {
            val response =postsRepo.getPosts()
            if (response.isSuccessful){
                val posts=response.body()?: emptyList()

                postLiveData.postValue(posts)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}