package com.hyunjung.toyprojectapp.gallery

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
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

        binding.infoBtnRotation.setOnClickListener {
            val orientation = this.resources.configuration.orientation

            when(orientation){
                Configuration.ORIENTATION_PORTRAIT -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                Configuration.ORIENTATION_LANDSCAPE -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }
        }
    }
}