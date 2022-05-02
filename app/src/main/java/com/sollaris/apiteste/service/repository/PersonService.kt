package com.sollaris.apiteste.service.repository

import com.sollaris.apiteste.service.model.HeaderModel
import com.sollaris.apiteste.service.model.PersonModel
import com.sollaris.apiteste.viewmodel.SearchViewModel
import com.sollaris.apiteste.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.http.*

interface PersonService {

    @POST("oauth/token")
    @FormUrlEncoded
    fun login(
        @Header("Authorization") token: String,
        @Field("grant_type") grant_type: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<HeaderModel>

    @GET("/api/usuario")
    fun searchAll(): Call<List<PersonModel>>

    @GET("/api/usuario/{id}")
    fun searchByID(@Path(value = "id", encoded = true) id: Int): Call<PersonModel>

    @POST("api/usuario/cadastrar")
    @FormUrlEncoded
    fun create(
        @Field("id") userID: Int,
        @Field("ativo") userSts: Boolean,
        @Field("email") userMail: String,
        @Field("funcao") userOcup: String,
        @Field("nomeCompleto") userFName: String,
        @Field("comeTratamento") userDname: String,
        @Field("senha") userPass: String,
        @Field("telefoneCelular") userHPhone: String,
        @Field("telefoneComercial") userCPhone: String,
    ): Call<Boolean>

//  @PUT("api/usuario/editar")
    @HTTP(method = "PUT", path = "api/usuario/editar", hasBody = true)
    @FormUrlEncoded
    fun update(
    @Field("id") userID: Int,
    @Field("ativo") userSts: Boolean,
    @Field("email") userMail: String,
    @Field("funcao") userOcup: String,
    @Field("nomeCompleto") userFName: String,
    @Field("comeTratamento") userDname: String,
    @Field("senha") userPass: String,
    @Field("telefoneCelular") userHPhone: String,
    @Field("telefoneComercial") userCPhone: String,
    ): Call<Boolean>

    @DELETE("/api/usuario/excluir/{id}")
    fun delete(@Path(value = "id", encoded = true) id: Int): Call<UserViewModel>

}