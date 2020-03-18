package com.example.uitest2application

import android.view.View
import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class Main2ActivityTest {
    private val input1 = "123"
    private val input2 = "1234"

    @Before
    fun onSetup() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.ed_input1)).perform(typeText(input1), closeSoftKeyboard())
        onView(withId(R.id.ed_input2)).perform(typeText(input2), closeSoftKeyboard())
    }

    @Test
    fun onCheckValueEditText() {
        onView(withId(R.id.ed_input1)).check(matches(isEditTextValueDouble()))
        onView(withId(R.id.ed_input2)).check(matches(isEditTextValueDouble()))
    }

    @Test
    fun actionButtonAdd() {
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.tv_result)).check(matches(withText("${input1.toDouble() + input2.toDouble()}")))
        onView(withId(R.id.tv_result)).check(matches(withText("${input1.toDouble() + input2.toDouble()}")))
    }

    private fun isEditTextValueDouble(): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
            }

            override fun matchesSafely(item: View?): Boolean {
                if (item is EditText) {
                    val value = item.text.toString()
                    return try {
                        value.toDouble()
                        true
                    } catch (e: Exception) {
                        false
                    }
                }
                return false
            }

        }

    }

}