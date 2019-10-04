package com.example.unittests

import java.lang.Math.abs
import java.lang.Math.pow
import kotlin.math.pow

class Math {

    fun sumOfSquares(x: Int, y: Int): Int{
        return (x*x)+(y*y)
    }

    fun differenceAbsoluteValues(x: Int, y: Int): Int {
        return abs(x)-abs(y)
    }

    fun factorial(x: Int): Int{
        var xCopy = x
        var sum = 1
        while(xCopy >= 2){
            sum = sum*xCopy
            xCopy = xCopy-1
        }
        return sum
    }
}