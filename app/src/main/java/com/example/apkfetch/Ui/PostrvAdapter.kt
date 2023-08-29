package com.example.apkfetch.Ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apkfetch.databinding.PostListBinding
import com.example.apkfetch.model.Post

class PostrvAdapter (var posts:List<Post>):RecyclerView.Adapter<PostrvAdapter.PostViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val binding=PostListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return PostViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            val currentPosts=posts[position]
            val binding=holder.binding
            binding.tvUserId.text=currentPosts.id.toString()
            binding.tvBody.text=currentPosts.body
            binding.rvPosts.text=currentPosts.id.toString()
            binding.tvTittle.text=currentPosts.title

        }

        override fun getItemCount(): Int {
            return posts.size

        }
        class PostViewHolder(var binding:PostListBinding): RecyclerView.ViewHolder(binding.root)
}