package com.sollaris.apiteste.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sollaris.apiteste.service.repository.PersonRepository

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val mPersonRepository = PersonRepository()

    fun doLogin(type: String, email: String, password: String){
        mPersonRepository.login(type, email, password)
    }

}