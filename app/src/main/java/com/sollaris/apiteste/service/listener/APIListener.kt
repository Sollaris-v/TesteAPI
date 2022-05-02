package com.sollaris.apiteste.service.listener

import com.sollaris.apiteste.service.model.HeaderModel

interface APIListener<T> {

    fun onSuccess(model: T)

    fun onFailure(message: String)

}