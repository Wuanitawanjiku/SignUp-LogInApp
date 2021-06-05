package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin:Button
    lateinit var btnSignUp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews2()
        login()
    }
        fun castViews2(){
            etEmail = findViewById(R.id.etEmail)
            etPassword = findViewById(R.id.etPassword)
            btnLogin=findViewById(R.id.btnLogIn)
            btnSignUp=findViewById(R.id.btnSignUp)

        }
    fun login(){
        btnLogin.setOnClickListener {
            if (etEmail.text.toString().isEmpty()||etPassword.text.toString().isEmpty()){
                etEmail.setError("Please input Email")
                etPassword.setError("Please input password")

            }else{
                Toast.makeText(baseContext,"Welcome to my App",Toast.LENGTH_SHORT).show()
            }

        }
    }

}

data class logInDetails(
    var email: String,
    var password: String
)
