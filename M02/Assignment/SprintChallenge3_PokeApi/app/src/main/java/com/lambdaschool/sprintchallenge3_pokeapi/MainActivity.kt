package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<Pokemon> {
    companion object {

        var pokeList: MutableList<Pokemon> = arrayListOf()

        var search: MutableList<Pokemon> = arrayListOf()

        var favoritesList: MutableList<Pokemon> = arrayListOf()

    }
    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        Toast.makeText(this, "The call failed", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        if (response.isSuccessful) {
            search.clear()
            search.add(response.body()!!)
            if (!pokeList.contains(response.body()!!)) {
                pokeList.add(response.body()!!)
            }
            context.apply {
                search
            }
        } else {
            Toast.makeText(this, "was not successful", Toast.LENGTH_SHORT)
        }    }

    internal var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        names_list_layout

        findViewById<View>(R.id.search_button).setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra("Search_Parameter", (findViewById<View>(R.id.search_bar) as EditText).text.toString())
            startActivityForResult(intent, 0)
        }
    }

    private fun buildTextView(name: String?): TextView {
        val view = TextView(this)
        view.text = name
        view.textSize = 14f
        view.setPadding(10, 10, 10, 10)
        view.setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra("Search_Parameter", name)
            startActivityForResult(intent, 0)
        }
        view.setOnLongClickListener { clickedView ->
            names_list_layout?.removeView(clickedView)
            true
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                0 -> {
                    val pokemon = data!!.getSerializableExtra("pokemon") as Pokemon
                    names_list_layout?.addView(buildTextView(pokemon.name))
                }
            }
        }
    }
}
