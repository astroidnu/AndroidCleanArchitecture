package com.scoproject.androidcleanarchitecture.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by ibnumuzzakkir on 05/06/18.
 * Mobile Engineer
 */

sealed class MovieDetail {

    data class Response(
            @SerializedName("adult") val adult: Boolean? = null,
            @SerializedName("backdrop_path") val backdropPath: String? = null,
            @SerializedName("belongs_to_collection") val belongsToCollection: BelongsToCollection? = null,
            @SerializedName("budget") val budget: Int? = null,
            @SerializedName("genres") val genres: List<Genres>? = null,
            @SerializedName("homepage") val homePage: String? = null,
            @SerializedName("id") val id: String? = null,
            @SerializedName("imdb_id") val imdbId: String? = null,
            @SerializedName("original_language") val originalLanguage: String? = null,
            @SerializedName("original_title") val originalTitle: String? = null,
            @SerializedName("overview") val overview: String? = null,
            @SerializedName("popularity") val popularity: String? = null,
            @SerializedName("production_companies") val productionCompanies: List<ProductionCompanies>? = null,
            @SerializedName("production_countries") val productionCountries: List<ProductionCountries>? = null,
            @SerializedName("release_date") val releaseDate: String? = null,
            @SerializedName("revenue") val revenue: Int? = null,
            @SerializedName("runtime") val runtime: Int? = null,
            @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguages>? = null,
            @SerializedName("status") val status: String? = null,
            @SerializedName("tagline") val tagline: String? = null,
            @SerializedName("title") val title: String? = null,
            @SerializedName("video") val video: Boolean? = null,
            @SerializedName("vote_average") val voteAverage: Double? = null,
            @SerializedName("vote_count") val voteCount: Int? = null
    )

    data class BelongsToCollection(
            @SerializedName("id") val id: Long? = null,
            @SerializedName("name") val name: String? = null,
            @SerializedName("poster_path") val posterPath: String? = null,
            @SerializedName("backdrop_path") val backdropPath: String? = null
    )

    data class Genres(
            @SerializedName("id") val id: Long? = null,
            @SerializedName("name") val name: String? = null
    )

    data class ProductionCompanies(
            @SerializedName("id") val id: Long? = null,
            @SerializedName("logo_path") val logoPath: String? = null,
            @SerializedName("name") val name: String? = null,
            @SerializedName("origin_country") val originCountry: String? = null
    )


    data class ProductionCountries(
            @SerializedName("iso_3166_1") val iso31661: String? = null,
            @SerializedName("name") val name: String? = null
    )

    data class SpokenLanguages(
            @SerializedName("iso_639_1") val iso6391: String? = null,
            @SerializedName("name") val name: String? = null
    )


}