package com.example.uitest4application.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uitest4application.R
import com.example.uitest4application.utils.launcherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_load.setOnClickListener {
            launcherActivity<CountryActivity>()
        }
    }
}
