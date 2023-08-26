package com.example.apkfetch.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.apkfetch.R
import com.example.apkfetch.ViewModel.PostViewModel
import com.example.apkfetch.apis.ApiInterface
import com.example.apkfetch.Repository.PostRepository

class MainActivity : AppCompatActivity() {
    val postViewModel:PostsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postViewModel.fetchPosts()
        postViewModel.postLiveData.observe(this,Observer {postsList->
            Toast.makeText(baseContext,
                "fetched ${postsList?.size}posts",
                Toast.LENGTH_LONG
            ).show()
            binding.rvPosts.layoutManager=LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter=PostRvAdapter(postsList)
        })
        postViewModel.errorLiveData.observe(this,Observer{error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })
    }
}

