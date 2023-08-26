package com.example.apkfetch.Ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apkfetch.model.Post
import com.example.post.databinding.PostListItemBinding


class PostrvAdapter {

    var posts:List<Post>):RecyclerView.Adapter<PostRvAdapter.PostViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val binding=PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return PostViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            val currentPosts=posts.get(position)
            val binding=holder.binding
            binding.tvId.text=currentPosts.id.toString()
            binding.tvUserId.text=currentPosts.UserId.toString()
            binding.tvBody.text=currentPosts.body
            binding.tvTitle.text=currentPosts.body

        }

        override fun getItemCount(): Int {
            return posts.size

        }

        class PostViewHolder(var binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root)
}