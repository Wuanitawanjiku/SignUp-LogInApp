package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var btnSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews2()
        check()
    }


    fun check() {

        btnLogIn.setOnClickListener {
            if (etEmail.text.toString().isEmpty()||(etPassword.text.toString().isEmpty())){
                etEmail.setError("Email required")
                etPassword.setError("Password required")
            } else {
                Toast.makeText(baseContext, "Welcome to my app", Toast.LENGTH_LONG).show()

            }
        }
            btnSignUp.setOnClickListener {
                var intent = Intent(baseContext, SignUp::class.java)
                startActivity(intent)
            }
        }
        fun castViews2() {
            etEmail = findViewById(R.id.etEmail)
            etPassword = findViewById(R.id.etPassword)
            btnLogIn = findViewById(R.id.btnLogIn)
            btnSignUp = findViewById(R.id.btnSignUp)
        }
    }