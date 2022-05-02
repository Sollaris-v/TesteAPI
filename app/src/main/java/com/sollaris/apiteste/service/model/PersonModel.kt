package com.sollaris.apiteste.service.model

import com.google.gson.annotations.SerializedName

class PersonModel {

    @SerializedName("Id")
    var userID: Int = 0

    @SerializedName("ativo")
    var userSts: Boolean = true

    @SerializedName("nomeTratamento")
    var userDname: String = ""

    @SerializedName("nomeCompleto")
    var userFName: String = ""

    @SerializedName("funcao")
    var userOcup: String = ""

    @SerializedName("telefoneComercial")
    var userHPhone: String = ""

    @SerializedName("telefoneCelular")
    var userCPhone: String = ""

    @SerializedName("email")
    var userMail: String = ""

    @SerializedName("senha")
    var userPass: String = ""


}