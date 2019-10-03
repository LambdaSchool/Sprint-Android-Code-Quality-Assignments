package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_pokemon_details.*

class PokemonDetailsActivity : AppCompatActivity() {

    private lateinit var pokemonViewModel: PokemonViewModel
    private var pokemon : Pokemon? = null
    private lateinit var bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        pokemonViewModel.getPokemonByName(intent.getStringExtra("Search_Parameter")).observe(this,
                object: Observer<Pokemon>{
                    override fun onChanged(t: Pokemon?) {
                        t?.let{
                            if(it.id != 0) {
                                pokemon = it
                                Thread(Runnable(){
                                    bitmap = pokemon?.sprite!!
                                    runOnUiThread {
                                        background_image.setImageBitmap(bitmap)

                                        text_title.text = pokemon?.name
                                        type_A.text = pokemon?.typeA
                                        type_B.text = pokemon?.typeB
                                        text_number.text = String.format("No %03d", pokemon?.id)

                                        for (move in pokemon?.moves!!) {
                                            layout_moves_list.addView(buildTextView(move))
                                        }
                                        progress_circular.visibility = View.INVISIBLE
                                    }
                                }).start()

                            }
                        }
                    }
                })
    }

    private fun buildTextView(moveName: String): TextView {
        val view = TextView(this)
        view.text = moveName
        view.textSize = 14f
        view.setPadding(10, 10, 10, 10)
        return view
    }

    override fun onBackPressed() {
        if(pokemon != null) {
            setResult(Activity.RESULT_OK, Intent().putExtra("pokemon", pokemon))
        } else{
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
