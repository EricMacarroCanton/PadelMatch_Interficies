package com.example.padelmatch_interficies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OnlyloginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onlylogin)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin?.setOnClickListener {
            val intent = Intent(this@OnlyloginActivity, pantalla_partits::class.java)
            startActivity(intent)
        }

        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister?.setOnClickListener {
            val intent = Intent(this@OnlyloginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}