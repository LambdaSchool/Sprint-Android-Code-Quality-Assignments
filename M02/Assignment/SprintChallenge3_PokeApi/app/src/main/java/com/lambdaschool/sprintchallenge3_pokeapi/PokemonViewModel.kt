package com.lambdaschool.sprintchallenge3_pokeapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PokemonViewModel: ViewModel() {

    private val pokeRepo = PokemonRepo()

    fun getPokemonByName(name: String): MutableLiveData<Pokemon>{
        return pokeRepo.getPokemonByName(name)
    }
}