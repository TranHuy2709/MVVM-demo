package com.exercise.jsonplaceholderapi.data.rohto.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("errors")
    var errors: Any?,
    @SerializedName("status")
    var status: String?
)