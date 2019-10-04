package com.example.unittests

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class CalculatorUnitTest {

    val math = mock(Math::class.java)
    val calculator = Calculator(math)

    @Test
    fun factorial_isCorrect(){
        //setup
        val x = 5
        val expected = 120
        `when`(math.factorial(x)).thenReturn(120)

        //execute
        val result = calculator.factorial(x)

        //check
        assertEquals(expected, result)
    }

    @Test
    fun absoluteDifference_isCorrect(){
        val x = -54
        val y = 25
        val expected = 29
        `when`(math.differenceAbsoluteValues(x, y)).thenReturn(expected)

        val result = calculator.absoluteDifference(x, y)

        assertEquals(expected, result)
    }

    @Test
    fun squaresum_isCorrect(){
        val y = 5
        val x = 3
        val expected = 34
        `when`(math.sumOfSquares(x,y)).thenReturn(34)

        val result = calculator.sumOfSquares(x, y)

        assertEquals(expected, result)
    }
}