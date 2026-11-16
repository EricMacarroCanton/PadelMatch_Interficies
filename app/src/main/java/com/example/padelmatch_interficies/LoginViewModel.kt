package com.example.padelmatch_interficies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    //LiveData privat per gestionar l'estat intern dels errors o del resultat del login
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    //Funció de lògica per validar i processar el login
    fun onLoginClicked(user: String, pass: String) {
        if (user.isBlank() || pass.isBlank()) {
            _errorMessage.value = "El usuari i la contrasenya no poden estar buits"
            _loginResult.value = false
        } else if (pass.length < 6) {
            _errorMessage.value = "La contrasenya ha de tenir almenys 6 caràcters"
            _loginResult.value = false
        } else {
            _errorMessage.value = null
            _loginResult.value = true // Login correcte
        }
    }
}