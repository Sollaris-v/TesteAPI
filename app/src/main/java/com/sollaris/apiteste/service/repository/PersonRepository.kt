package com.sollaris.apiteste.service.repository

import android.content.Context
import com.google.gson.Gson
import com.sollaris.apiteste.R
import com.sollaris.apiteste.service.constants.Constants
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.model.HeaderModel
import com.sollaris.apiteste.service.model.PersonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(grant_type: String, email: String, password: String, listener: APIListener<HeaderModel>) {
        val call: Call<HeaderModel> =
            mRemote.login(" Basic c2FsdmF0b3JpbXZuOnNhbHZhdG9yaQ==", grant_type, email, password)


        call.enqueue(object : Callback<HeaderModel> {

            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                if (response.code() != Constants.HTTP.SUCCESS) {
                    val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
//                    listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
                    listener.onFailure(validation)
                } else {
                    response.body()?.let {listener.onSuccess(it)}
                }

//               response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })
    }


    fun all(listener: APIListener<List<PersonModel>>){
        val call: Call<List<PersonModel>> = mRemote.searchAll()
        call.enqueue(object : Callback<List<PersonModel>>{

            override fun onResponse(
                call: Call<List<PersonModel>>,
                response: Response<List<PersonModel>>
            ) {
                if (response.code() != Constants.HTTP.SUCCESS) {
                    listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
                } else {
                    response.body()?.let {listener.onSuccess(it)}
                }
            }

            override fun onFailure(call: Call<List<PersonModel>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

        })

    }


    fun create(person: PersonModel, listener: APIListener<Boolean>) {
        val call: Call<Boolean> = mRemote.create(
            person.userID,
            person.userSts,
            person.userMail,
            person.userOcup,
            person.userFName,
            person.userDname,
            person.userPass,
            person.userHPhone,
            person.userCPhone
        )
        call.enqueue(object : Callback<Boolean>{


            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.code() != Constants.HTTP.SUCCESS) {
//                    val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
//                    listener.onFailure(validation)
                } else {
                    response.body()?.let {listener.onSuccess(it)}
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
            }

        })
    }

//    fun create(userID: String, status: Boolean, userEmail: String, userOccupation: String, userFullName: String, userDisplayName: String, userPassword: String, userHomePhone: String, userCommercialPhone: String, listener: APIListener) {
//        val call: Call<HeaderModel> = mRemote.create(userID, status, userEmail, userOccupation, userFullName, userDisplayName, userPassword, userHomePhone, userCommercialPhone)
//
//
//        call.enqueue(object : Callback<HeaderModel>{
//
//            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
//                if (response.code() != Constants.HTTP.SUCCESS){
//                    val validation = Gson().fromJson(response.errorBody()!!.string(), String::class.java)
//                    listener.onFailure(context.getString(R.string.ERROR_UNEXPECTED))
//                }
//
////               response.body()?.let { listener.onSuccess(it) }
//            }
//
//            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
//                listener.onFailure(t.message.toString())
//            }
//
//        })
//    }

}