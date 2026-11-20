package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val tilName = findViewById<TextInputLayout>(R.id.tilName)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val tilEmail = findViewById<TextInputLayout>(R.id.tilEmail)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val tilPassword = findViewById<TextInputLayout>(R.id.tilPassword)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val tvGoToLogin = findViewById<TextView>(R.id.tvGoToLogin)

        registerViewModel.nomError.observe(this) { error ->
            tilName?.error = error
        }

        registerViewModel.emailError.observe(this) { error ->
            tilEmail?.error = error
        }

        registerViewModel.passwordError.observe(this) { error ->
            tilPassword?.error = error
        }

        registerViewModel.formulariValid.observe(this) { campsPlens ->
            btnRegister?.isEnabled = campsPlens
        }

        registerViewModel.registreExitos.observe(this) { esValid ->
            if (esValid) {
                Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, pantalla_partits::class.java))
                finish()
            }
        }

        val actualitzarEstatBoto = {
            registerViewModel.comprovarCampsBuits(
                etName?.text.toString(),
                etEmail?.text.toString(),
                etPassword?.text.toString()
            )
        }

        etName?.doAfterTextChanged { actualitzarEstatBoto() }
        etEmail?.doAfterTextChanged { actualitzarEstatBoto() }
        etPassword?.doAfterTextChanged { actualitzarEstatBoto() }

        btnRegister?.setOnClickListener {
            registerViewModel.validarRegistre(
                etName?.text.toString().trim(),
                etEmail?.text.toString().trim(),
                etPassword?.text.toString()
            )
        }

        tvGoToLogin?.setOnClickListener {
            registerViewModel.netejarErrors()
            finish()
        }
    }
}