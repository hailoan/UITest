package com.example.uitest3application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uitest3application.Constant.EXTRA_RESULT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    /**
     * init view
     */
    private fun initView() {
        rc_data.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = DataAdapter {
            launcherActivity<NextActivity> {
                putExtra(EXTRA_RESULT, "$it")
            }
        }
        val data= intArrayOf(1,5,22,66,2,7,54,95,100,24,55,32,11,67,63,45,86,82,12)
        adapter.updateData(data)
        rc_data.adapter=adapter
    }
}
