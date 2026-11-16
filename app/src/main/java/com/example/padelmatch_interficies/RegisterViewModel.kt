package com.example.padelmatch_interficies

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val _nomError = MutableLiveData<String?>()
    val nomError: LiveData<String?> = _nomError

    private val _emailError = MutableLiveData<String?>()
    val emailError: LiveData<String?> = _emailError

    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?> = _passwordError

    private val _confirmPasswordError = MutableLiveData<String?>()
    val confirmPasswordError: LiveData<String?> = _confirmPasswordError

    private val _registreExitos = MutableLiveData<Boolean>()
    val registreExitos: LiveData<Boolean> = _registreExitos


    fun validarRegistre(nom: String, email: String, password: String, confirmPassword: String) {
        var esValid = true

        // Validem nom d'usuari
        if (nom.isBlank()) {
            _nomError.value = "El nom d'usuari és obligatori"
            esValid = false
        } else if (nom.length < 3) {
            _nomError.value = "El nom ha de tenir com a mínim 3 caràcters"
            esValid = false
        } else {
            _nomError.value = null
        }
    }
}