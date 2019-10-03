package com.lambdaschool.sprintchallenge3_pokeapi

import android.graphics.Bitmap
import com.google.gson.JsonObject
import org.json.JSONException

import java.io.Serializable
import java.util.ArrayList

class Pokemon : Serializable {
    var id: Int = 0
        private set
    var moves: ArrayList<String>? = null
        private set
    var name: String? = null
        private set
    var typeA: String? = null
        private set
    var typeB: String? = null
        private set
    private var spriteUrl: String? = null

    val sprite: Bitmap?
        get() = NetworkAdapter.getBitmapFromURL(this.spriteUrl!!)

    constructor(name: String) {
        this.id = 0
        this.moves = ArrayList()
        this.name = name
        this.typeA = ""
        this.typeB = ""
        this.spriteUrl = ""
    }

    constructor(json: JsonObject) {
        try {
            this.id = json.get("id").asInt
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.name = json.get("name").asString
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.spriteUrl = json.get("sprites").asJsonObject.get("front_default").asString
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            val typesArray = json.getAsJsonArray("types")
            this.typeA = typesArray.get(0).asJsonObject.get("type").asJsonObject.get("name").asString
            //this.typeB = typesArray.get(1).asJsonObject.get("type").asJsonObject.get("name").asString
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        try {
            this.moves = ArrayList()
            val movesArray = json.getAsJsonArray("moves")
            for (i in 0 until movesArray.size()) {
                this.moves!!.add(movesArray.get(i).asJsonObject.get("move").asJsonObject.get("name").asString)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }
}
