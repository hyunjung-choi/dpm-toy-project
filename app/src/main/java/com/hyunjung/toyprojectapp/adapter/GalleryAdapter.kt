package com.hyunjung.toyprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyunjung.toyprojectapp.databinding.ItemGalleryBinding
import com.hyunjung.toyprojectapp.gallery.ImageDataItem

class GalleryAdapter : RecyclerView.Adapter<GalleryHolder>() {

    var imageData = ArrayList<ImageDataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryHolder, position: Int) {
        val image = imageData[position]
        holder.setPhoto(image)
    }

    override fun getItemCount(): Int = imageData.size

}

class GalleryHolder(private val binding: ItemGalleryBinding): RecyclerView.ViewHolder(binding.root){

    fun setPhoto(image : ImageDataItem) {
        Glide.with(itemView).load(image.download_url).into(binding.galleryItemIv)
    }

}