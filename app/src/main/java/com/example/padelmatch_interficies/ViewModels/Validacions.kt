package com.example.padelmatch_interficies.ViewModels


import android.util.Patterns

fun String.isValidEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword(): Boolean =
    length >= 8 && any { it.isDigit() } && any { it.isUpperCase() }

fun String.isValidUsername(): Boolean =
    length >= 3 && all { it.isLetterOrDigit() || it == '_' }