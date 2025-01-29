package com.shaileedemo.mvimovies.network.model

import com.google.gson.annotations.SerializedName

data class RemoteSearch(
    @SerializedName("Search") val search: List<RemoteMovie>,
    @SerializedName("totalResults") val totalResults: String,
)
