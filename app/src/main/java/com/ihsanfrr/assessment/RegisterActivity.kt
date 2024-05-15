package com.ihsanfrr.assessment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.dhaval2404.imagepicker.ImagePicker

class RegisterActivity : AppCompatActivity() {

    private lateinit var profile: ImageView
    private lateinit var fullName: EditText
    private lateinit var emailAddress: EditText
    private lateinit var password: EditText
    private lateinit var signUp: Button
    private lateinit var navigateToLogin: TextView
    private lateinit var builder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        profile = findViewById(R.id.profile)
        fullName = findViewById(R.id.fullName)
        emailAddress = findViewById(R.id.emailAddress)
        password = findViewById(R.id.password)
        signUp = findViewById(R.id.signUp)
        navigateToLogin = findViewById(R.id.navigateToLogin)

        profile.setOnClickListener {
            imagePicker()
        }

        signUp.setOnClickListener {
            signUpFunction()
        }

        navigateToLogin.setOnClickListener {
            moveActivity()
        }
    }

    private fun imagePicker() {
        ImagePicker.with(this).cropSquare().start()
    }

    private fun signUpFunction() {
        if(fullName.text.isEmpty() || emailAddress.text.isEmpty() || password.text.isEmpty()) {
            builder = AlertDialog.Builder(this)
            builder.setTitle("Warning!")
                .setMessage("All data must be filled in")
                .setCancelable(true)
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }

            builder.create().show()
        } else {
            fullName.setText("")
            emailAddress.setText("")
            password.setText("")

            builder = AlertDialog.Builder(this)
            builder.setTitle("Success!")
                .setMessage("Registration successfully")
                .setCancelable(true)
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
                Toast.makeText(this, "Login now!", Toast.LENGTH_SHORT).show()
            }

            builder.create().show()
        }
    }

    private fun moveActivity() {
        onBackPressedDispatcher.onBackPressed()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Activity.RESULT_OK -> {
                val uri: Uri = data?.data!!

                profile.setImageURI(uri)
            }
            ImagePicker.RESULT_ERROR -> {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}