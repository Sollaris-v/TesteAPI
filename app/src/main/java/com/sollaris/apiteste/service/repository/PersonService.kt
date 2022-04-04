package com.sollaris.apiteste.service.repository

import com.sollaris.apiteste.service.model.HeaderModel
import retrofit2.Call
import retrofit2.http.*
import java.util.*


interface PersonService {


    @POST("oauth/token")
    @FormUrlEncoded
//  @Headers("Authorization: Basic c2FsdmF0b3JpbXZuOnNhbHZhdG9yaQ==")
//    @Headers(value = ["Accept: application/json",
//        "Content-Type: application/x-www-form-urlencoded","Authorization: Basic c2FsdmF0b3JpbXZuOnNhbHZhdG9yaQ=="])
    fun login(
        @Header("Authorization") token: String,
        @Field("grant_type") grant_type: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<HeaderModel>
}