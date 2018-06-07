package com.scoproject.androidcleanarchitecture.data.model.entity

/**
 * Created by ibnumuzzakkir on 05/06/18.
 * Mobile Engineer
 */
sealed class MovieDetail {
    data class MovieVO (
            val movieTitle : String? = null,
            val movieBackDropPath: String? = null,
            val movieDescription : String? = null
    )
}