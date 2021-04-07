package com.hyunjung.toyprojectapp.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.hyunjung.toyprojectapp.adapter.GalleryAdapter
import com.hyunjung.toyprojectapp.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val photoData: MutableList<Photo> = loadPhotoData()
        val adapter = GalleryAdapter()
        adapter.photoData = photoData
        binding.galleryRv.adapter = adapter
        binding.galleryRv.layoutManager = GridLayoutManager(this.context, 4)

        return binding.root
    }

    private fun loadPhotoData(): MutableList<Photo>{
        val data: MutableList<Photo> = mutableListOf()

        for(i in 0..10){
            val author = "000"
            val width = 123
            val height = 456
            val url = "abc"
            val download = "abc"

            val photo = Photo(i.toString(), author, width, height, url, download)
            data.add(photo)
        }

        return data
    }
}