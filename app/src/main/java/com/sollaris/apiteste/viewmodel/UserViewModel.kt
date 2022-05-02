package com.sollaris.apiteste.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.listener.ValidationListener
import com.sollaris.apiteste.service.model.PersonModel
import com.sollaris.apiteste.service.repository.PersonRepository
import com.sollaris.apiteste.service.repository.SecurityPreferences

class UserViewModel (application: Application) : AndroidViewModel(application) {

    private val mPersonRepository = PersonRepository(application)
    private val mSharedPreferences = SecurityPreferences(application)

    private val mCreate = MutableLiveData<ValidationListener>()
    var create: LiveData<ValidationListener> = mCreate

    private val mValidation = MutableLiveData<ValidationListener>()
    var validation: LiveData<ValidationListener> = mValidation

    fun save(person: PersonModel){
        mPersonRepository.create(person, object : APIListener<Boolean> {
            override fun onSuccess(model: Boolean) {
                mValidation.value = ValidationListener()
            }

            override fun onFailure(message: String) {
                mValidation.value = ValidationListener(message)
            }

        })
    }

}


