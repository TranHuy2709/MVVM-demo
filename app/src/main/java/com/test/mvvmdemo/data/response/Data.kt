package com.exercise.jsonplaceholderapi.data.rohto.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("accessToken")
    var accessToken: String?,
    @SerializedName("refreshToken")
    var refreshToken: String?
)