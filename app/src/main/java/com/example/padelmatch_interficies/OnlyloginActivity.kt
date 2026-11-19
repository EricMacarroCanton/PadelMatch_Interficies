package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.padelmatch_interficies.ViewModels.LoginViewModel
import com.google.android.material.textfield.TextInputLayout

class OnlyloginActivity : AppCompatActivity() {

    // El ViewModel sobreviu a rotacions de pantalla
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onlylogin)

        val tilEmail = findViewById<TextInputLayout>(R.id.tilEmail)
        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegister = findViewById<Button>(R.id.btn_register)

        // Observadors: quan el LiveData canvia, la UI s'actualitza sola
        viewModel.emailError.observe(this) { error ->
            tilEmail.error = error
        }

        viewModel.passwordError.observe(this) { error ->
            tilPassword.error = error
        }

        viewModel.loginResult.observe(this) { ok ->
            if (ok) {
                viewModel.loginHandled()
                startActivity(Intent(this, pantalla_partits::class.java))
            }
        }

        btnLogin.setOnClickListener {
            viewModel.onLoginClicked(
                etEmail.text.toString().trim(),
                etPassword.text.toString()
            )
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}