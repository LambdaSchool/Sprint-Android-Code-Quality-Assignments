package com.lambdaschool.sprintchallenge3_pokeapi

import android.graphics.Bitmap
import org.json.JSONException
import org.json.JSONObject

import java.io.Serializable
import java.util.ArrayList



data class Sprites (val front_default: String)
data class Move(val name: String)
data class MoveList(val move: Move)
data class Type(val name: String)
data class TypeList(val type: Type)

data class Pokemon (
    val name: String,
    val sprites: Sprites,
    val id: Int,
    val moves: List<MoveList>,
    val types: List<TypeList>
)
data class PassPokemon(
    var name: String,
    var sprites: String,
    var id: Int,
    var moves: ArrayList<String>,
    var type: ArrayList<String>

): Serializable
// TODO 4 code below is constructed for HTTP calls, so mow gotta convert to retro calls
//class Pokemon : Serializable {
//    var id: Int = 0
//        private set
//    var moves: ArrayList<String>? = null
//        private set
//    var name: String? = null
//        private set
//    var typeA: String? = null
//        private set
//    var typeB: String? = null
//        private set
//    private var spriteUrl: String? = null
//
//    val sprite: Bitmap?
//        get() = NetworkAdapter.getBitmapFromURL(this.spriteUrl!!)
//
//    constructor(name: String) {
//        this.id = 0
//        this.moves = ArrayList()
//        this.name = name
//        this.typeA = ""
//        this.typeB = ""
//        this.spriteUrl = ""
//    }
//
//    constructor(json: JSONObject) {
//        try {
//            this.id = json.getInt("id")
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        try {
//            this.name = json.getString("name")
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        try {
//            this.spriteUrl = json.getJSONObject("sprites").getString("front_default")
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        try {
//            val typesArray = json.getJSONArray("types")
//            this.typeA = typesArray.getJSONObject(0).getJSONObject("type").getString("name")
//            this.typeB = typesArray.getJSONObject(1).getJSONObject("type").getString("name")
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//        try {
//            this.moves = ArrayList()
//            val movesArray = json.getJSONArray("moves")
//            for (i in 0 until movesArray.length()) {
//                this.moves!!.add(movesArray.getJSONObject(i).getJSONObject("move").getString("name"))
//            }
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//
//    }
//}
//