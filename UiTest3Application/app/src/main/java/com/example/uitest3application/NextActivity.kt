package com.example.uitest3application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uitest3application.Constant.EXTRA_RESULT
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        tv_result.text=intent.getStringExtra(EXTRA_RESULT)

    }
}
