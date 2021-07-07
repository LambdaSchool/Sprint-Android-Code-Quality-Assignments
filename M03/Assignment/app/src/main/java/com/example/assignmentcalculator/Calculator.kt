package com.example.assignmentcalculator

class Calculator(private val math: Math) {
    fun add(a: Float, b: Float): Float{
        return math.addNumbers(a, b)
    }
    fun subtract(a: Float, b: Float): Float{
        return math.subtractNumber(a, b)
    }
    fun multiply(a: Float, b: Float): Float{
        return math.multiplyNumbers(a, b)
    }
    fun divide(a: Float, b: Float): Float{
        return math.divideNumbers(a, b)
    }

}