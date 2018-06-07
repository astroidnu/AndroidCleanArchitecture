package com.scoproject.androidcleanarchitecture.data.model.response

import com.google.gson.annotations.SerializedName
import com.scoproject.androidcleanarchitecture.data.network.RestConstant

/**
 * Created by ibnumuzzakkir on 03/06/18.
 * Mobile Engineer
 */
sealed class MovieList {
    data class Response(
            @SerializedName("page") val page: Int? = null,
            @SerializedName("total_results") val totalResults: Int? = null,
            @SerializedName("total_pages") val totalPages: Int? = null,
            @SerializedName("results") val results: List<Result?>? = null
    )

    data class Result(
            @SerializedName("vote_count") val voteCount: Int? = null,
            @SerializedName("id") val id: Int? = null,
            @SerializedName("video") val video: Boolean? = null,
            @SerializedName("vote_average") val voteAverage: Double? = null,
            @SerializedName("title") val title: String? = null,
            @SerializedName("popularity") val popularity: Double? = null,
            @SerializedName("poster_path") val posterPath: String? = null,
            @SerializedName("original_language") val originalLanguage: String? = null,
            @SerializedName("original_title") val originalTitle: String? = null,
            @SerializedName("genre_ids") val genreIds: List<Int?>? = null,
            @SerializedName("backdrop_path") val backdropPath: String? = null,
            @SerializedName("adult") val adult: Boolean? = null,
            @SerializedName("overview") val overview: String? = null,
            @SerializedName("release_date") val releaseDate: String? = null){

             val fullpathMovieList: String = "${RestConstant.baseImageUrl}${RestConstant.imageSettings.w342}/$posterPath"

    }

}