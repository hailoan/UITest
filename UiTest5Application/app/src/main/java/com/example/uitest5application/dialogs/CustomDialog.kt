package com.example.uitest5application.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.uitest5application.R
import kotlinx.android.synthetic.main.dialog_custom.*

class CustomDialog(
    context: Context,
    private val onClick: () -> Unit,
    var title: String = ""
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        btn_close.setOnClickListener {
            onClick()
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        tv_title.text = title
    }

}