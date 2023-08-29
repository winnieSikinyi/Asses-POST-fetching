package com.example.apkfetch.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apkfetch.apis.ApiInterface
import com.example.apkfetch.Repository.PostRepository
import com.example.apkfetch.ViewModel.PostsViewModel
import com.example.apkfetch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val postViewModel: PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()
        postViewModel.postLiveData.observe(this, Observer {postsList->
            var postAdapt=PostrvAdapter(postsList ?: emptyList())
            binding.rvRecycler.layoutManager=LinearLayoutManager(this@MainActivity)
            binding.rvRecycler.adapter=postAdapt
            Toast.makeText(baseContext,
                "fetched ${postsList?.size}posts",
                Toast.LENGTH_LONG
            ).show()
        })
        postViewModel.errorLiveData.observe(this,{error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })
    }
}

