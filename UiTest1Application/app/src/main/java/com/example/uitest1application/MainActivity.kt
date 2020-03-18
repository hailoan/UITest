package com.example.uitest1application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    /**
     * init view
     */
    private fun initView() {
        btn_add.setOnClickListener {
            tv_result.text = actionAdd(ed_input1, ed_input2)
        }
    }

    private fun actionAdd(input1: EditText, input2: EditText): String {
        return try {
            val a = input1.text.toString().toDouble()
            val b = input2.text.toString().toDouble()
            (a + b).toString()
        } catch (e: NumberFormatException) {
            "Invalidate"
        }

    }
}
