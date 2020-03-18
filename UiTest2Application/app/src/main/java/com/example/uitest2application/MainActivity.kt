package com.example.uitest2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uitest2application.Constant.EXTRA_RESULT
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
            try {
                val a = ed_input1.text.toString().toDouble()
                val b = ed_input2.text.toString().toDouble()
                launcherActivity<NextActivity> {
                    putExtra(EXTRA_RESULT, "${a + b}")
                }
            } catch (e: NumberFormatException) {
                baseContext.makerToast("Invalidate")
            }
        }
    }
}
