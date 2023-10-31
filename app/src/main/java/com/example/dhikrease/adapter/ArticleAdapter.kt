package com.example.dhikrease.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dhikrease.databinding.ArticleFragmentBinding
import com.example.dhikrease.model.ArticleModel
import com.example.dhikrease.ui.detail.DetailArticleActivity

class ArticleAdapter (private val listArtikel: ArrayList<ArticleModel>) :
    RecyclerView.Adapter<ArticleAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: detail ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ArticleFragmentBinding.inflate(LayoutInflater.from(parent.context), parent,  false)
        return  MyViewHolder(binding)
    }


    override fun getItemCount(): Int =  listArtikel.size



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listArtikel[position]

        Glide.with(holder.itemView.context)
            .load(data.imageArtikel)
            .into(holder.binding.imgFragment1)

        holder.binding.imgFragment1.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailArticleActivity::class.java)
            intentDetail.putExtra(DetailArticleActivity.DETAIL_DESC, data.descArtikel)
            intentDetail.putExtra(DetailArticleActivity.DETAIL_TITLE, data.titleArtikel)
            intentDetail.putExtra(DetailArticleActivity.DETAIL_IMAGE, data.imageArtikel)
            holder.itemView.context.startActivity(intentDetail)
        }





    }
}