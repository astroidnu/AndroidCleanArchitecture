package com.scoproject.androidcleanarchitecture.data.model.entity

import com.scoproject.androidcleanarchitecture.data.network.RestConstant

/**
 * Created by ibnumuzzakkir on 05/06/18.
 * Mobile Engineer
 */
sealed class MovieDetail {
    data class MovieVO (
            val movieTitle : String? = null,
            val movieBackDropPath: String? = null,
            val movieDescription : String? = null
    ){
       val fullPathMovieDetail = "${RestConstant.baseImageUrl}${RestConstant.imageSettings.w1280}/$movieBackDropPath"
    }
}