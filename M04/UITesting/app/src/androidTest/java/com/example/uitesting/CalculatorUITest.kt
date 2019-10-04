package com.example.uitesting

import android.view.View
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher


@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CalculatorUITest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun shouldAdd9ToUI(){
        //setup
        val text = "9"
        onView(withId(R.id.number_9))
            .perform(click())

        //execute
        onView(withId(R.id.output_screen))
            .perform(setTextInTextView(text))

        onView(withId(R.id.output_screen)).check(matches(withText(text)))
    }

    @Test
    fun shouldDeleteLastElement(){
        //setup
        val text = "90"
        onView(withId(R.id.number_9)).perform(click())
        onView(withId(R.id.number_0)).perform(click())
        onView(withId(R.id.number_2)).perform(click())

        //execute
        onView(withId(R.id.remove_recent_char)).perform(click())

        //check
        onView(withId(R.id.output_screen)).check(matches(withText(text)))
    }

    @Test
    fun shouldAddElements(){
        //setup
        val text = "90"
        onView(withId(R.id.number_5)).perform(click())
        onView(withId(R.id.number_7)).perform(click())

        //execute
        onView(withId(R.id.addition)).perform(click())
        onView(withId(R.id.number_3)).perform(click())
        onView(withId(R.id.number_3)).perform(click())

        //check
        onView(withId(R.id.output_screen)).check(matches(withText(text)))
    }

    @Test
    fun shouldMultiplyElements(){
        //setup
        val text = "90"
        onView(withId(R.id.number_1)).perform(click())
        onView(withId(R.id.number_8)).perform(click())

        //execute
        onView(withId(R.id.multiplication)).perform(click())
        onView(withId(R.id.number_5)).perform(click())

        //check
        onView(withId(R.id.output_screen)).check(matches(withText(text)))
    }

    @Test
    fun shouldDivideElements(){
        //setup
        val text = "4"
        onView(withId(R.id.number_1)).perform(click())
        onView(withId(R.id.number_6)).perform(click())

        //execute
        onView(withId(R.id.division)).perform(click())
        onView(withId(R.id.number_4)).perform(click())

        //check
        onView(withId(R.id.output_screen)).check(matches(withText(text)))
    }

    fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return allOf(isDisplayed(), isAssignableFrom(TextView::class.java))
                //
                // To check that the found view is TextView or it's subclass like EditText
                // so it will work for TextView and it's descendants
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return "replace text"
            }
        }
    }
}