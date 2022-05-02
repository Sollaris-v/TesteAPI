package com.sollaris.apiteste.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.model.PersonModel
import com.sollaris.apiteste.service.repository.PersonRepository

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    private val mPersonRepository = PersonRepository(application)

    private val mList = MutableLiveData<List<PersonModel>>()
    var person: LiveData<List<PersonModel>> = mList

    fun list(){
        mPersonRepository.all(object : APIListener<List<PersonModel>>{
            override fun onSuccess(model: List<PersonModel>) {
                mList.value = model
            }

            override fun onFailure(message: String) {
               mList.value = arrayListOf()
            }

        })
    }


}