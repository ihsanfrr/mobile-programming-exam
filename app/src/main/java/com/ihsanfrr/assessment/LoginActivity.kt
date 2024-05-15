package com.ihsanfrr.assessment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var emailAddress: EditText
    private lateinit var password: EditText
    private lateinit var signIn: Button
    private lateinit var createNewAccount: Button
    private lateinit var builder: AlertDialog.Builder

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        emailAddress = findViewById(R.id.emailAddress)
        password = findViewById(R.id.password)
        signIn = findViewById(R.id.signIn)
        createNewAccount = findViewById(R.id.createNewAccount)

        signIn.setOnClickListener {
            signInFunction()
        }

        createNewAccount.setOnClickListener {
            moveActivity()
        }
    }

    private fun signInFunction() {
        if (emailAddress.text.toString().trim() == "ihsanfrr@gmail.com" && password.text.toString().trim() == "12345") {
            emailAddress.setText("")
            password.setText("")
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            builder = AlertDialog.Builder(this)
            builder.setTitle("Warning!")
                .setMessage("Incorrect email address or password")
                .setCancelable(true)
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }

            builder.create().show()
        }
    }

    private fun moveActivity() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}