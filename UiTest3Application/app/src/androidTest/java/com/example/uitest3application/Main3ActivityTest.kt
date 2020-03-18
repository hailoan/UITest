package com.example.uitest3application

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Main3ActivityTest {
    private val data= intArrayOf(1,5,22,66,2,7,54,95,100,24,55,32,11,67,63,45,86,82,12)
    @get:Rule
    var main3Activity = IntentsTestRule(MainActivity::class.java)

    @Test
    fun actionClickItem() {
        val positionClick = 3
        onView(withId(R.id.rc_data)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                positionClick,
                click()
            )
        )
        intended(hasComponent(NextActivity::class.java.name))
        onView(withId(R.id.tv_result)).check(matches(withText(data[positionClick].toString())))
    }

}