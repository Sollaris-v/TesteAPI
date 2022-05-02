package com.sollaris.apiteste.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sollaris.apiteste.R
import com.sollaris.apiteste.service.listener.PersonListener
import com.sollaris.apiteste.service.model.PersonModel
import com.sollaris.apiteste.view.viewholder.PersonViewHolder

class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {

    private var mList: List<PersonModel> = arrayListOf()
    private lateinit var mListener: PersonListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_person_list, parent, false)
        return PersonViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindData(mList[position])
    }

    fun attachListener(listener: PersonListener){
        mListener = listener
    }

    fun updateListener(list: List<PersonModel>) {
        mList = list
        notifyDataSetChanged()
    }

}