package com.sollaris.apiteste.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sollaris.apiteste.R
import com.sollaris.apiteste.databinding.ActivityMainBinding
import com.sollaris.apiteste.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        doLogin()
        observe()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }

    private fun observe(){
        mViewModel.login.observe(this, Observer {

            var menssage = ""

            if (it.success()) {
                menssage = "Logado com sucesso!"
                Toast.makeText(applicationContext, menssage, Toast.LENGTH_SHORT).show()
//                showBasicDialog(null, menssage)
            } else {
                menssage = it.failure()
                Toast.makeText(applicationContext, menssage, Toast.LENGTH_SHORT).show()
//                showBasicDialog(null, menssage)
            }
        })
    }




    private fun doLogin() {
        val type = "password"
        val email = "samuelottoni13@gmail.com"
        val password = "samuel@13"

        mViewModel.doLogin(type, email, password)

    }

    fun showBasicDialog(view: View?, menssage: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Login")
        builder.setMessage(menssage)
        builder.show()
    }








    //Mandar para o ModelView?

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

}