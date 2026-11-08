package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister?.setOnClickListener {
            val intent = Intent(this@RegisterActivity, pantalla_partits::class.java)
            startActivity(intent)
        }

        val tvGoToLogin = findViewById<TextView>(R.id.tvGoToLogin)
        tvGoToLogin?.setOnClickListener {
            finish()
        }
    }
}