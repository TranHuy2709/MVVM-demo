package com.test.mvvmdemo.data

import com.exercise.jsonplaceholderapi.data.rohto.response.LoginResponse
import com.test.mvvmdemo.data.body.LoginUser
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RohtoApi {

    @Headers("Content-Type: application/json")
    @POST("login")
    suspend fun login(@Body loginUser: LoginUser): LoginResponse?

    companion object{
        private const val BASE_URL= "http://45.118.144.92:8117/api/"

        fun create():RohtoApi{
            val retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RohtoApi::class.java)
        }
    }
}