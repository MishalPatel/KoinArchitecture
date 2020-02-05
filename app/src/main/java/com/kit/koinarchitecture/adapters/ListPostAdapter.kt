package com.kit.koinarchitecture.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kit.koinarchitecture.BR
import com.kit.koinarchitecture.R
import com.kit.koinarchitecture.data.model.Posts
import com.kit.koinarchitecture.databinding.ItemListPostBinding

class ListPostAdapter : RecyclerView.Adapter<ListPostAdapter.ListViewHolder>(){
    val listPost = ArrayList<Posts>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_post,parent,false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listPost.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        holder.binding?.setVariable(BR.strForks, listPost[position].forks.toString())
//        holder.binding?.setVariable(BR.strStars, listPost[position].stars.toString())
        holder.binding?.setVariable(BR.strRepoName, listPost[position].title)
        holder.binding?.setVariable(BR.strDescription, listPost[position].body)
    }

    class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val binding = DataBindingUtil.bind<ItemListPostBinding>(itemView)
    }

    fun addPostData(listPosts : List<Posts>){
        this.listPost.addAll(listPosts)
        notifyDataSetChanged()
    }

}