package com.sollaris.apiteste.service.repository

import android.content.Context
import com.google.gson.Gson
import com.sollaris.apiteste.R
import com.sollaris.apiteste.service.constants.Constants
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.model.HeaderModel
import com.sollaris.apiteste.service.repository.PersonService
import com.sollaris.apiteste.service.repository.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PersonRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(grant_type: String, email: String, password: String, listener: APIListener) {
        val call: Call<HeaderModel> = mRemote.login(" Basic c2FsdmF0b3JpbXZuOnNhbHZhdG9yaQ==",grant_type, email, password)
        call.enqueue(object : Callback<HeaderModel>{

            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
               if (response.code() != Constants.HTTP.SUCCESS){
                   val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                   listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
               }

//               response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }

}