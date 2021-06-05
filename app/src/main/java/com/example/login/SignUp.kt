package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*

class SignUp : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var spGender: Spinner
    lateinit var etEmail: EditText
    lateinit var etPhoneNumber: EditText
    lateinit var etPassword: EditText

    lateinit var btnSignUp: Button
    lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        castViews()
        clickRegister()

    }

    fun castViews() {

        etName = findViewById(R.id.etName)
        spGender = findViewById(R.id.spGender)
        val gender = arrayOf("Male", "Female", "Prefer not to say")
        val genderAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, gender)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGender.adapter = genderAdapter

        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etPassword = findViewById(R.id.etPassword)

        btnSignUp = findViewById(R.id.btnSignUp)
        btnLogIn = findViewById(R.id.btnLogIn)

    }


    fun clickRegister() {
        btnSignUp.setOnClickListener {
            var gender = spGender.selectedItem.toString()
        if (etName.text.toString().isEmpty()||etEmail.text.toString().isEmpty()||etPhoneNumber.text.toString().isEmpty()||
            etPassword.text.toString().isEmpty()){
            etName.setError("Name required")
            etEmail.setError("Input email to continue")
            etPhoneNumber.setError("Phone number is required")
            etPassword.setError("Password is Required")
        }
        else{
            val accountDetails = AccountDetails(name = etName.text.toString(), gender = "", email = etEmail.text.toString(),
                phoneNumber = etPhoneNumber.text.toString(), password = etPassword.text.toString())
            Toast.makeText(baseContext,accountDetails.toString(), Toast.LENGTH_LONG).show()
        }

        }


        btnLogIn.setOnClickListener {
            var intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent) }
    }


    data class AccountDetails(
        var name: String,
        var gender: String,
        var email: String,
        var phoneNumber: String,
        var password: String
    )
}