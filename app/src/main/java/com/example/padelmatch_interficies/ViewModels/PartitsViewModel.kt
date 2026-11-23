package com.example.padelmatch_interficies.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.padelmatch_interficies.Partit
import com.example.padelmatch_interficies.filtrarPer

class PartitsViewModel : ViewModel() {

    private val llistaCompleta = mutableListOf<Partit>()
    private var filtreNivell: String? = null
    private var filtrePosicio: String? = null

    private val _partits = MutableLiveData<List<Partit>>(emptyList())
    val partits: LiveData<List<Partit>> get() = _partits

    fun afegirPartit(partit: Partit) {
        llistaCompleta.add(partit)
        actualitza()
    }

    fun esborrarPartit(partit: Partit) {
        llistaCompleta.removeAll { it.id == partit.id }
        actualitza()
    }

    fun editarPartit(nou: Partit) {
        val i = llistaCompleta.indexOfFirst { it.id == nou.id }
        if (i >= 0) {
            llistaCompleta[i] = nou
            actualitza()
        }
    }

    fun aplicarFiltre(nivell: String?, posicio: String?) {
        filtreNivell = nivell
        filtrePosicio = posicio
        actualitza()
    }

    private fun actualitza() {
        _partits.value = llistaCompleta.filtrarPer(filtreNivell, filtrePosicio)
    }
}