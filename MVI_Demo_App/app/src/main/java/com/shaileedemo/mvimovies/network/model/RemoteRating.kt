package com.shaileedemo.mvimovies.network.model

import com.google.gson.annotations.SerializedName

data class RemoteRating(
    @SerializedName("Source") val source: String?,
    @SerializedName("Value") val value: String?
)
