package com.sollaris.apiteste.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sollaris.apiteste.service.constants.Constants
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.listener.ValidationListener
import com.sollaris.apiteste.service.model.HeaderModel
import com.sollaris.apiteste.service.model.PersonModel
import com.sollaris.apiteste.service.repository.PersonRepository
import com.sollaris.apiteste.service.repository.RetrofitClient
import com.sollaris.apiteste.service.repository.SecurityPreferences


class MainViewModel(application: Application) : AndroidViewModel(application){

    private val mPersonRepository = PersonRepository(application)
    private val mLogin = MutableLiveData<ValidationListener>()
    var login: LiveData<ValidationListener> = mLogin
    private val mSharedPreferences = SecurityPreferences(application)

//    private val mValidation = MutableLiveData<ValidationListener>()
//    var validation: LiveData<ValidationListener> = mValidation

    fun doLogin(type: String, email: String, password: String){
        mPersonRepository.login(type, email, password, object : APIListener<HeaderModel>{
            override fun onSuccess(model: HeaderModel) {

                mSharedPreferences.store(Constants.SHARED.ACESS_TOKEN, model.acessToken)
                mSharedPreferences.store(Constants.SHARED.REFRESH_TOKEN, model.refreshToken)
                mSharedPreferences.store(Constants.SHARED.TIME_TOKEN, model.timeToken)

                RetrofitClient.addheader(model.acessToken, model.refreshToken)

                mLogin.value = ValidationListener()
            }

            override fun onFailure(str: String) {

                mLogin.value = ValidationListener(str)
            }

        })
    }

//    fun save(person: PersonModel){
//        mPersonRepository.create(person, object : APIListener<Boolean>{
//            override fun onSuccess(model: Boolean) {
//                mValidation.value = ValidationListener()
//            }
//
//            override fun onFailure(message: String) {
//                mValidation.value = ValidationListener(message)
//            }
//
//        })
//    }


//     Implementar depois, pois o token de acesso expira rapido
//    fun verifyLoggedUser(){
//        val token = mSharedPreferences.get(Constants.SHARED.ACESS_TOKEN)
//    }

}