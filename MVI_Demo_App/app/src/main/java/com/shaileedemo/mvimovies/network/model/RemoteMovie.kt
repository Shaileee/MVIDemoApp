package com.shaileedemo.mvimovies.network.model

import com.google.gson.annotations.SerializedName
import com.shaileedemo.mvimovies.network.model.Constants.IMDBID
import com.shaileedemo.mvimovies.network.model.Constants.POSTER
import com.shaileedemo.mvimovies.network.model.Constants.TITLE
import com.shaileedemo.mvimovies.network.model.Constants.TYPE
import com.shaileedemo.mvimovies.network.model.Constants.YEAR

data class RemoteMovie(
    @SerializedName(TITLE) val title: String?,
    @SerializedName(YEAR) val year: String?,
    @SerializedName(IMDBID) val imdbId: String,
    @SerializedName(TYPE) val type: String,
    @SerializedName(POSTER) val poster: String
)
