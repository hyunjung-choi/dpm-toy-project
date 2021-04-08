package com.hyunjung.toyprojectapp.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hyunjung.toyprojectapp.databinding.ActivityImageInfoBinding

class ImageInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityImageInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getStringExtra("image")
        val author = intent.getStringExtra("author")
        val width = intent.getStringExtra("width")
        val height = intent.getStringExtra("height")

        Glide.with(this).load(image).into(binding.infoIvImage)
        binding.infoTvAuthor.text = "Author: ${author}"
        binding.infoTvSize.text = "Size: ${width}x${height}"
    }
}