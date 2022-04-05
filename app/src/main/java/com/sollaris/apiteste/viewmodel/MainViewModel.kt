package com.sollaris.apiteste.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sollaris.apiteste.service.constants.Constants
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.listener.ValidationListener
import com.sollaris.apiteste.service.model.HeaderModel
import com.sollaris.apiteste.service.repository.PersonRepository
import com.sollaris.apiteste.service.repository.SecurityPreferences


class MainViewModel(application: Application) : AndroidViewModel(application){

    private val mPersonRepository = PersonRepository(application)
    private val mLogin = MutableLiveData<ValidationListener>()
    var login: LiveData<ValidationListener> = mLogin
    private val mSharedPreferences = SecurityPreferences(application)

    fun doLogin(type: String, email: String, password: String){
        mPersonRepository.login(type, email, password, object : APIListener{
            override fun onSuccess(model: HeaderModel) {

                mSharedPreferences.store(Constants.SHARED.ACESS_TOKEN, model.acessToken)
                mSharedPreferences.store(Constants.SHARED.REFRESH_TOKEN, model.refreshToken)
                mSharedPreferences.store(Constants.SHARED.TIME_TOKEN, model.timeToken)

                mLogin.value = ValidationListener()
            }

            override fun onFailure(str: String) {

                mLogin.value = ValidationListener(str)
            }

        })
    }

}