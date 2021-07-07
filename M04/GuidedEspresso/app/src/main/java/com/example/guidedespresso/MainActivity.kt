package com.example.guidedespresso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_TITLE = "TITLE_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        //add listeners to buttons
        change_title_button.setOnClickListener {
            title_view.text = getString()
        }

        pass_title_button.setOnClickListener {
            val newTitle = getString()
         //   title_view.text = newTitle
            //passing intent to the next activity
            val intent = Intent(this@MainActivity, ShowTitleActivity::class.java)
            intent.putExtra(KEY_TITLE, newTitle)
            startActivity(intent)
        }
    }

    private fun getString() = title_input.text.toString()


}