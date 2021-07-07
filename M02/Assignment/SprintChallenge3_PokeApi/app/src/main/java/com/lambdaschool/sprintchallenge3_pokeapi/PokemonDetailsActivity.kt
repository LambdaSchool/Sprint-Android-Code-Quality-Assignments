package com.lambdaschool.sprintchallenge3_pokeapi

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.ArrayList


//TODO 6 making a retrofit callback on detail activity since thats where all the details for pokemon are displayed
class PokemonDetailsActivity : AppCompatActivity(), Callback<Pokemon> {
    //TODO 6a instead of passing previous Pokemon we are passing new Pass Pokemon
 //   internal var pokemon: Pokemon? = null
    internal var pokemon: PassPokemon? = null
    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        println(t)
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if (response.isSuccessful){
            val p = response.body()!!
            Picasso.get().load(p.sprites.front_default).into(background_image)
            findViewById<View>(R.id.progress_circular).visibility = View.INVISIBLE
            text_title?.text = p.name
            type_A?.text = p.types[0].type.name
            if (p.types.size > 1)type_B?.text = p.types[1].type.name

            text_number?.text = String.format("No %03d", p.id)
            val movesViews = ArrayList<View>()
            for (move in p.moves) {
                movesViews.add(buildTextView(move.move.name))
            }
            runOnUiThread {
                for (moveView in movesViews) {
                    layout_moves_list?.addView(moveView)
                }
            }
            val pokemonMoves = ArrayList<String>()
            p.moves.forEach {
                pokemonMoves.add(it.move.name)
            }
            val pokemonType = ArrayList<String>()
            p.types.forEach{
                pokemonType.add(it.type.name)
            }
            pokemon = PassPokemon(p.name, p.sprites.front_default, p.id, pokemonMoves, pokemonType)
        } else {println(response)}
            }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
    //TODO 7 last to do for the conversion, instead of getting intent from HTTP request,
        // we will get intent from retrofit that requires enqueue?
        PokemonDao.getPokemon(intent.getStringExtra("Search_Parameter")).enqueue(this)
        //GetPokemon().execute(intent.getStringExtra("Search_Parameter"))
    }

    private fun buildTextView(moveName: String): TextView {
        val view = TextView(this)
        view.text = moveName
        view.textSize = 14f
        view.setPadding(10, 10, 10, 10)
        return view
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK, Intent().putExtra("pokemon", pokemon))
        finish()
    }

    // TODO 7a it appears I no longer need aSyncTask (clarify with instructor)

   /* inner class GetPokemon : AsyncTask<String, Pokemon, Bitmap>() {

        override fun onPostExecute(bitmap: Bitmap) {
            background_image?.setImageBitmap(bitmap)
            findViewById<View>(R.id.progress_circular).visibility = View.INVISIBLE
        }

        override fun onProgressUpdate(vararg values: Pokemon) {
            pokemon = values[0]
            text_title?.text = values[0].name
            type_A?.text = values[0].typeA
            type_B?.text = values[0].typeB
            text_number?.text = String.format("No %03d", values[0].id)

            val movesViews = ArrayList<View>()
            for (move in values[0].moves!!) {
                movesViews.add(buildTextView(move))
            }
            runOnUiThread {
                for (moveView in movesViews) {
                    layout_moves_list?.addView(moveView)
                }
            }
        }

        @SuppressLint("WrongThread")
        override fun doInBackground(vararg strings: String): Bitmap? {
            val loading = PokemonDao.getPokemon(strings[0])
            onProgressUpdate(loading)
            return loading.sprite
        }
    }*/
}
