package com.hyunjung.toyprojectapp.gallery

data class Photo (
        var id: String,
        var author: String,
        var width: Int,
        var height: Int,
        var url: String,
        var download_url: String
        )