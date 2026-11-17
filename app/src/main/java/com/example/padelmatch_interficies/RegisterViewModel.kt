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

        // Validem nom usuari
        if (nom.isBlank()) {
            _nomError.value = "El nombre de usuario es obligatorio"
            esValid = false
        } else if (nom.length < 3) {
            _nomError.value = "El nombre debe tener como mínimo 3 caracteres"
            esValid = false
        } else {
            _nomError.value = null
        }

        // Valdem correu electronic
        if (email.isBlank()) {
            _emailError.value = "El correo electronico es obligatorio"
            esValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailError.value = "El formato del correo no es valido"
            esValid = false
        } else {
            _emailError.value = null
        }

        // Validem contraseña
        if (password.isBlank()) {
            _passwordError.value = "Debes introducir una contraseña"
            esValid = false
        } else if (password.length < 6) {
            _passwordError.value = "La contraseña debe tener como mínimo 6 caracteres"
            esValid = false
        } else {
            _passwordError.value = null
        }

        // Validem coincidencia de contrasenyes
        if (confirmPassword != password) {
            _confirmPasswordError.value = "Las contraseñas no coinciden"
            esValid = false
        } else {
            _confirmPasswordError.value = null
        }

        _registreExitos.value = esValid
    }
}