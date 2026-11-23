package com.example.padelmatch_interficies.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _emailError = MutableLiveData<String?>()
    val emailError: LiveData<String?> get() = _emailError

    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?> get() = _passwordError

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    fun onLoginClicked(email: String, pass: String) {
        _emailError.value = when {
            email.isBlank() -> "L'email no pot estar buit"
            !email.isValidEmail() -> "El format de l'email no és vàlid"
            else -> null
        }

        _passwordError.value = when {
            pass.isBlank() -> "La contrasenya no pot estar buida"
            pass.length < 6 -> "La contrasenya ha de tenir almenys 6 caràcters"
            else -> null
        }

        _loginResult.value = _emailError.value == null && _passwordError.value == null
    }

    fun loginHandled() {
        _loginResult.value = false
    }
}