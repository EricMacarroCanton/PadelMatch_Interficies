package com.example.padelmatch_interficies.ViewModels

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

    private val _registreExitos = MutableLiveData<Boolean>()
    val registreExitos: LiveData<Boolean> = _registreExitos

    private val _formulariValid = MutableLiveData<Boolean>()
    val formulariValid: LiveData<Boolean> = _formulariValid

    private val _nivellError = MutableLiveData<String?>()
    val nivellError: LiveData<String?> = _nivellError

    fun validarRegistre(nom: String, email: String, password: String, nivell: String) {
        var esValid = true

        if (nom.isBlank()) {
            _nomError.value = "El nombre de usuario es obligatorio"
            esValid = false
        } else if (nom.length < 3) {
            _nomError.value = "El nombre debe tener como mínimo 3 caracteres"
            esValid = false
        } else if (!nom.matches(Regex("^[a-zA-Z0-9_]+$"))) {
            _nomError.value = "Solo se permiten letras, números y guiones bajos"
            esValid = false
        } else {
            _nomError.value = null
        }

        if (email.isBlank()) {
            _emailError.value = "El correo electronico es obligatorio"
            esValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailError.value = "El formato del correo no es valido"
            esValid = false
        } else {
            _emailError.value = null
        }

        if (password.isBlank()) {
            _passwordError.value = "Debes introducir una contraseña"
            esValid = false
        } else if (password.length < 6) {
            _passwordError.value = "La contraseña debe tener como mínimo 6 caracteres"
            esValid = false
        } else if (!password.any { it.isDigit() } || !password.any { it.isUpperCase() }) {
            _passwordError.value = "Debe incluir al menos una mayúscula y un número"
            esValid = false
        } else {
            _passwordError.value = null
        }

        val nivellNum = nivell.replace(",", ".").toDoubleOrNull()
        if (nivell.isBlank()) {
            _nivellError.value = "El nivel de pádel es obligatorio"
            esValid = false
        } else if (nivellNum == null || nivellNum < 1.0 || nivellNum > 7.0) {
            _nivellError.value = "El nivel debe estar entre 1 y 7"
            esValid = false
        } else {
            _nivellError.value = null
        }

        _registreExitos.value = esValid
    }

    fun comprovarCampsBuits(nom: String, email: String, password: String, nivell: String) {
        _formulariValid.value = nom.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                nivell.isNotBlank()
    }

    fun netejarErrors() {
        _nomError.value = null
        _emailError.value = null
        _passwordError.value = null
        _nivellError.value = null
        _registreExitos.value = false
    }
}