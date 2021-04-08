package com.hyunjung.toyprojectapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyunjung.toyprojectapp.databinding.ItemGalleryBinding
import com.hyunjung.toyprojectapp.gallery.ImageDataItem
import com.hyunjung.toyprojectapp.gallery.ImageInfoActivity

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

        itemView.setOnClickListener {
            val intent = Intent(it.context, ImageInfoActivity::class.java)
            intent.putExtra("image", image.download_url)
            intent.putExtra("author", image.author)
            intent.putExtra("width", image.width.toString())
            intent.putExtra("height", image.height.toString())
            it.context.startActivity(intent)
        }
    }

}