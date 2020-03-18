package com.example.uitest5application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uitest5application.dialogs.CustomDialog
import com.example.uitest5application.utils.makerToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dialog: CustomDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    /**
     * init view
     */
    private fun initView() {
        dialog = CustomDialog(this, {
            baseContext.makerToast("dialog dismiss")
        })
        btn_show_dialog.setOnClickListener {
            dialog.title = "Dialog Title"
            dialog.show()
        }
    }
}
