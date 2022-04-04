package com.sollaris.apiteste.service.repository

import com.sollaris.apiteste.service.model.HeaderModel
import com.sollaris.apiteste.service.repository.PersonService
import com.sollaris.apiteste.service.repository.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PersonRepository {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(grant_type: String, email: String, password: String) {
        val call: Call<HeaderModel> = mRemote.login(" Basic c2FsdmF0b3JpbXZuOnNhbHZhdG9yaQ==",grant_type, email, password)
        call.enqueue(object : Callback<HeaderModel>{

            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                val header = response.body()
            }

            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                val s = ""
            }

        })
    }

}