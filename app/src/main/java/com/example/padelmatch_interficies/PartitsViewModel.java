package com.example.padelmatch_interficies.ViewModels;

public class PartitsViewModel {

    class PartitsViewModel : ViewModel() {

        private val llistaCompleta = mutableListOf<Partit>()

        private val _partitsFiltrats = MutableLiveData<List<Partit>>()
        val partitsFiltrats: LiveData<List<Partit>> = _partitsFiltrats

        init {
            carregarDadesInicials()
        }
}
