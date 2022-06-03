package com.test.mvvmdemo.data.body


import com.google.gson.annotations.SerializedName

 class LoginUser{
    @SerializedName("password")
    var password: String= "123456"
    @SerializedName("userName")
    var userName: String= "0963531018"
}