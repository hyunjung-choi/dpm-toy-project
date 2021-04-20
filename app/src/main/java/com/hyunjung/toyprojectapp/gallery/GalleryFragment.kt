package com.hyunjung.toyprojectapp.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.hyunjung.toyprojectapp.adapter.GalleryAdapter
import com.hyunjung.toyprojectapp.databinding.FragmentGalleryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    companion object {
        fun newInstance(): GalleryFragment{
            val args = Bundle()
            val fragment = GalleryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)

        loadImageData()

        return binding.root
    }


    private fun loadImageData(){
        val retrofit = Retrofit.Builder()
                .baseUrl(ImageApi.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val imageInfo = retrofit.create(ImageInfo::class.java)

        imageInfo.getImgageInfo().enqueue(object : Callback<ImageData>{
            override fun onResponse(call: Call<ImageData>, response: Response<ImageData>) {
                Toast.makeText(this@GalleryFragment.context, "성공", Toast.LENGTH_LONG).show()
                getImagesSuccess(response.body())
            }

            override fun onFailure(call: Call<ImageData>, t: Throwable) {
                Toast.makeText(this@GalleryFragment.context, "데이터를 가져올 수 없습니다.", Toast.LENGTH_LONG).show()
            }
        })
    }


    fun getImagesSuccess(response: ImageData?){
        val data: ArrayList<ImageDataItem> = arrayListOf()

        if (response != null) {
            for(image in response){
                data.add(image)
            }
        }

        val adapter = GalleryAdapter()
        adapter.submitList(data)
        binding.galleryRv.adapter = adapter
        binding.galleryRv.layoutManager = GridLayoutManager(this.context, 4)
    }
}