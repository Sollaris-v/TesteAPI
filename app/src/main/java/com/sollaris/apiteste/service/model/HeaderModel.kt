package com.sollaris.apiteste.service.model

import com.google.gson.annotations.SerializedName

class HeaderModel {

    @SerializedName("access_token")
    var acessToken: String = ""

    @SerializedName("refresh_token")
    var refreshToken: String = ""

    @SerializedName("expires_in")
    var timeToken: String = ""

}