package com.tr4n.moviedb.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tr4n.moviedb.BuildConfig
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieSimilar(
    @SerializedName("adult")
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("genre_ids")
    var genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("video")
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null
) : Parcelable {

    fun getFullBackdropPath() =
        (BuildConfig.LARGE_IMAGE_URL + backdropPath).takeIf { backdropPath.isNullOrBlank().not() }

    fun getFullPosterPath() =
        (BuildConfig.SMALL_IMAGE_URL + posterPath).takeIf { posterPath.isNullOrBlank().not() }
}
