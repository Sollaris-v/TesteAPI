package com.sollaris.apiteste.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sollaris.apiteste.R
import com.sollaris.apiteste.service.model.PersonModel
import com.sollaris.apiteste.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user.*


class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: UserViewModel
    private var mPersonID = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        mViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        listeners()
        observe()


    }

    private fun observe(){
        mViewModel.validation.observe(this, androidx.lifecycle.Observer {
            if (it.success()) {
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun listeners() {
        save_user.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.save_user) {
            handleSave()
        } else if (id == R.id.delete_user) {
            //handleDelete()
        }
    }

    private fun handleSave(){
        val person = PersonModel().apply {
                this.userSts = user_active.isChecked
                this.userDname = user_display_name.text.toString()
                this.userFName = user_full_name.text.toString()
                this.userOcup = user_occupation.selectedItem.toString()
                this.userHPhone = user_home_phone.text.toString()
                this.userCPhone = user_commercial_phone.text.toString()
                this.userMail = user_email.text.toString()
                this.userPass = user_password.text.toString()
        }
        mViewModel.save(person)
    }





}


