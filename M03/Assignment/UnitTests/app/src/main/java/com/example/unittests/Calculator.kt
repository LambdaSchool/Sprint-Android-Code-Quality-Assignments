package com.example.unittests

class Calculator(val math: Math) {

    fun factorial(input: Int): Int{
        return math.factorial(input)
    }

    fun absoluteDifference(x: Int, y: Int): Int{
        return math.differenceAbsoluteValues(x, y)
    }

    fun sumOfSquares(x: Int, y: Int): Int{
        return math.sumOfSquares(x, y)
    }
}