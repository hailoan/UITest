package com.example.uitest4application

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitest4application.data.model.City
import com.example.uitest4application.data.repo.Repository
import com.example.uitest4application.screens.CountryActivity
import com.example.uitest4application.screens.MainActivity
import com.example.uitest4application.screens.NextActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class Main4ActivityTest : KoinTest {
    private val repository: Repository by inject()
    private lateinit var data: List<City>

    @Rule
    @JvmField
    var main4Activity = IntentsTestRule(MainActivity::class.java)

    @Before
    fun onSetup() {
        data = repository.getData("cities.json")
    }

    @Test
    fun actionLoadCities() {
        onView(withId(R.id.btn_load)).perform(ViewActions.click())
        intended(hasComponent(CountryActivity::class.java.name))
        actionClickPositionInsideRecyclerView(0)
        intended(hasComponent(NextActivity::class.java.name))
        Espresso.pressBack()
        onView(withId(R.id.rc_country)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                data.size - 1
            )
        )
        actionClickPositionInsideRecyclerView(data.size - 1)
    }

    private fun actionClickPositionInsideRecyclerView(pos: Int) {
        onView(withId(R.id.rc_country)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                pos,
                ViewActions.click()
            )
        )
        onView(withId(R.id.tv_result)).check(matches(withText(data[pos].name)))
    }

}