package com.hyunjung.toyprojectapp.gallery

import retrofit2.Call
import retrofit2.http.GET

class ImageApi {
    companion object{
        const val DOMAIN = "https://picsum.photos/"
    }
}

interface ImageInfo {
    @GET("v2/list")
    fun getImgageInfo(): Call<ImageData>
}