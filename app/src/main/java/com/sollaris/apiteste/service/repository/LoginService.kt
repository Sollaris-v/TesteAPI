package com.sollaris.apiteste.service.repository

import com.sollaris.apiteste.service.model.HeaderModel
import retrofit2.Call
import retrofit2.http.*
import java.util.*


interface LoginService {


    @POST("oauth/token")
    @FormUrlEncoded

    fun login(
        @Header("Authorization") token: String,
        @Field("grant_type") grant_type: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<HeaderModel>
}