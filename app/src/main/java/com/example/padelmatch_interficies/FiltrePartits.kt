package com.example.padelmatch_interficies

fun List<Partit>.filtrarPer(nivell: String?, posicio: String?): List<Partit> =
    this.filter { nivell.isNullOrBlank() || it.nivel.equals(nivell, ignoreCase = true) }
        .filter { posicio.isNullOrBlank() || it.posicion.equals(posicio, ignoreCase = true) }