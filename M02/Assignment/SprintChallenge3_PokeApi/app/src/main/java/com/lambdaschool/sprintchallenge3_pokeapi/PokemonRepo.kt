package com.lambdaschool.sprintchallenge3_pokeapi

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepo {

    private var pokemonLiveData = MutableLiveData<Pokemon>(Pokemon(""))

    fun getPokemonByName(name: String): MutableLiveData<Pokemon>{

        PokemonApi.getTripApiCall().getPokemonByName(name).enqueue(
            object : Callback<JsonObject>{
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    throw t
                }

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    response.body()?.let{
                        updatePokemonLiveData(Pokemon(it))
                    }
                }
            })

        return pokemonLiveData
    }

    fun updatePokemonLiveData(it: Pokemon){
        pokemonLiveData.value = it
    }
}