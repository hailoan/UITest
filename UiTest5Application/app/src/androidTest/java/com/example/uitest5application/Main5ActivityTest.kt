package com.example.uitest5application

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class Main5ActivityTest {
    private fun getResourceString(id: Int): String? {
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        return targetContext.resources.getString(id)
    }
    private fun isKeyboardShown(): Boolean {
        val inputMethodManager = InstrumentationRegistry.getInstrumentation().targetContext.getSystemService(
            Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.isAcceptingText
    }

    @Test
    fun actionShowDialogWhenClick() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btn_show_dialog)).perform(click())
            onView(withText("Dialog Title")).check(matches(isDisplayed()))
    }

    @Test
    fun actionDismissDialogWhenClickButtonClose() {
        ActivityScenario.launch(MainActivity::class.java)
        actionShowDialogWhenClick()
        onView(withId(R.id.btn_close)).perform(click())
    }

    @Test
    fun editTextWhenFocusEditText() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.ed_text)).check(matches(withHint(getResourceString(
            R.string.input_text
        ))))
        onView(withId(R.id.ed_text)).perform(click())
        check(isKeyboardShown())
        onView(withId(R.id.ed_text)).check(matches(isDisplayed()))
    }


}