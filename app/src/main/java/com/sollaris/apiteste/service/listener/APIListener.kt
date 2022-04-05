package com.sollaris.apiteste.service.listener

import com.sollaris.apiteste.service.model.HeaderModel

interface APIListener {

    fun onSuccess(model: HeaderModel)

    fun onFailure(message: String)

}