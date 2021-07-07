package com.lambdaschool.sprintchallenge3_pokeapi

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

object PokemonDao {
    // TODO 7c since I change the endpoint url for GET i have to change it in BASE URL as well(can use postman to test)
    private val POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/" // add pokemon name as
    // private val POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/%s/" // add pokemon name as



    //TODO 5 DAO also set up fpr network adapter, thats where we can add the retro fit builder since
    // the BASE URL is right here and we can list an interface as well
    fun getPokemon(name: String): Call<Pokemon> {
        val logger = HttpLoggingInterceptor()
        val okHttp = OkHttpClient.Builder()
                //TODO 5a add Stetho
            .addNetworkInterceptor(StethoInterceptor()).addInterceptor(logger)
            .retryOnConnectionFailure(false)
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(11, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(POKEMON_URL)
            .client(okHttp)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(PokemonCall::class.java).getPokemonByName(name)
    }
    interface PokemonCall {
        @GET("{name-id}")
        fun getPokemonByName(@Path("name-id") pokemonNameNumber: String): Call<Pokemon>
    }

   // fun getPokemon(name: String): Pokemon {
   //     var pokemon: Pokemon
   //     try {
   //         pokemon = Pokemon(JSONObject(NetworkAdapter.httpRequest(String.format(POKEMON_URL, name), "GET")))
   //     } catch (e: JSONException) {
   //         e.printStackTrace()
   //         pokemon = Pokemon(name)
   //     }
//
   //     return pokemon
   // }
}
