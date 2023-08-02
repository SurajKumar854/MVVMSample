package com.example.dependencyinjection.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.dependencyinjection.presentation.viewmodels.MyViewModel
import com.example.dependencyinjection.retrofit.utilis.ApiState
import com.example.dependencyinjection.room.entity.AppUsers
import com.example.mvvmmodel.R


import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var showText: TextView
    lateinit var name: EditText
    lateinit var saveBtn: Button
    val viewModel: MyViewModel by viewModels()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setObserver()
        LoadDataFromRemoteServer()









        showText = findViewById(R.id.showText)
        name = findViewById(R.id.name)
        saveBtn = findViewById(R.id.saveBtn)


        /* viewModel.username.observe(this, { username -> showText.text = "Username : $username" })
 */

        saveBtn.setOnClickListener {
/*
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.insertUser(AppUsers("1", "Suda", "85912708921"))
            }*/
        }


    }

    private fun LoadDataFromRemoteServer() {
        CoroutineScope(Dispatchers.IO).launch {
            // viewModel.getUser1()
            viewModel.getUsersList()
        }
    }

    private fun setObserver() {
        viewModel.loadImageResourceResponseObserver.observe(this, { res ->
        })
        viewModel.userListResponseObserver.observe(this, { res ->

            when (res) {
                is ApiState.Loading -> {
                    showText.text = "Loading"
                }

                is ApiState.Success -> {
                    showText.text = res.data.get(0).email
                }
            }
        })


     /*   viewModel._createAppUserResponseObserver.observe(this, { res ->

            when (res) {
                is ApiState.Loading -> {
                    showText.text = "Loading"
                }

                is ApiState.Success -> {
                    Toast.makeText(this, "Created", Toast.LENGTH_LONG).show()
                }
            }
        })
*/
    }


}