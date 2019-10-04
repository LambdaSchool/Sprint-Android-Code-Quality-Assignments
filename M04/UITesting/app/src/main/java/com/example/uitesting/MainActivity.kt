package com.example.uitesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var currentOperator: String? = null
    private var previousNumber = 0
    private var currentNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(view: View?) {

        view?.let{
            when(it.id){
                R.id.number_0 -> processNumberInput(0)
                R.id.number_1 -> processNumberInput(1)
                R.id.number_2 -> processNumberInput(2)
                R.id.number_3 -> processNumberInput(3)
                R.id.number_4 -> processNumberInput(4)
                R.id.number_5 -> processNumberInput(5)
                R.id.number_6 -> processNumberInput(6)
                R.id.number_7 -> processNumberInput(7)
                R.id.number_8 -> processNumberInput(8)
                R.id.number_9 -> processNumberInput(9)
                R.id.remove_recent_char -> {
                    output_screen.text = "${output_screen.text.subSequence(0, output_screen.text.length-1)}"
                }
                R.id.addition -> {
                    currentOperator = "+"
                    previousNumber = output_screen.text.toString().toInt()
                    output_screen.text = ""
                }
                R.id.multiplication -> {
                    currentOperator = "*"
                    previousNumber = output_screen.text.toString().toInt()
                    output_screen.text = ""
                }
                R.id.division -> {
                    currentOperator = "/"
                    previousNumber = output_screen.text.toString().toInt()
                    output_screen.text = ""
                }
                R.id.subtraction -> {
                    currentOperator = "-"
                    previousNumber = output_screen.text.toString().toInt()
                    output_screen.text = ""
                }
                R.id.equals -> {
                    val n = output_screen.text.toString().toInt()
                    when(currentOperator){
                        "+" -> output_screen.text = "${(previousNumber + n).toString()}"
                        "-" -> output_screen.text = "${(previousNumber - n).toString()}"
                        "*" -> output_screen.text = "${(previousNumber * n).toString()}"
                        "/" -> output_screen.text = "${(previousNumber / n).toString()}"
                    }
                    currentOperator = null
                }
            }
        }
    }

    private fun processNumberInput(i: Int){
        output_screen.text = "${output_screen.text}$i"
    }
}
