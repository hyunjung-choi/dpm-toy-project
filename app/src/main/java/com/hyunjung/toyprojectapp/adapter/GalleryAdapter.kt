package com.hyunjung.toyprojectapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyunjung.toyprojectapp.R
import com.hyunjung.toyprojectapp.databinding.ItemGalleryBinding
import com.hyunjung.toyprojectapp.gallery.Photo

class GalleryAdapter : RecyclerView.Adapter<GalleryHolder>() {

    var photoData = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GalleryHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryHolder, position: Int) {
        val photo = photoData[position]
        holder.setPhoto(photo)
    }

    override fun getItemCount(): Int = photoData.size
}

class GalleryHolder(private val binding: ItemGalleryBinding): RecyclerView.ViewHolder(binding.root){

    fun setPhoto(photo: Photo) {
        val id = photo.id.toInt()
        if(id % 2 == 0){
            binding.galleryItemIv.setImageResource(R.drawable.cherry)
        }
        else{
            binding.galleryItemIv.setImageResource(R.drawable.tm)
        }
    }

}