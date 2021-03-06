package com.sollaris.apiteste.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sollaris.apiteste.R
import com.sollaris.apiteste.service.listener.PersonListener
import com.sollaris.apiteste.service.model.PersonModel

class PersonViewHolder (itemView: View, val listener: PersonListener) :
    RecyclerView.ViewHolder(itemView) {

//    private var mTextDescription: TextView = itemView.findViewById(R.id.text_description)
//    private var mTextPriority: TextView = itemView.findViewById(R.id.text_priority)
//    private var mTextDueDate: TextView = itemView.findViewById(R.id.text_due_date)
//    private var mImageTask: ImageView = itemView.findViewById(R.id.image_task)

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    fun bindData(person: PersonModel) {

//        this.mTextDescription.text = ""
//        this.mTextPriority.text = ""
//        this.mTextDueDate.text = ""
//
//        // Eventos
//        // mTextDescription.setOnClickListener { listener.onListClick(task.id) }
//        // mImageTask.setOnClickListener { }
//
//        mTextDescription.setOnLongClickListener {
//            AlertDialog.Builder(itemView.context)
//                .setTitle(R.string.remocao_de_tarefa)
//                .setMessage(R.string.remover_tarefa)
//                .setPositiveButton(R.string.sim) { dialog, which ->
//                    // listener.onDeleteClick(task.id)
//                }
//                .setNeutralButton(R.string.cancelar, null)
//                .show()
//            true
//        }

    }

}