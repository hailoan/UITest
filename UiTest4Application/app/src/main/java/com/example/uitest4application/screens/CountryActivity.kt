package com.example.uitest4application.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uitest4application.adapter.CountryAdapter
import com.example.uitest4application.R
import com.example.uitest4application.data.repo.Repository
import com.example.uitest4application.utils.Constant
import com.example.uitest4application.utils.launcherActivity
import kotlinx.android.synthetic.main.activity_country.*
import org.koin.android.ext.android.inject


class CountryActivity : AppCompatActivity() {
    private lateinit var adapter: CountryAdapter
    private val repo: Repository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        initView()
    }

    /**
     * init view
     */
    private fun initView() {
        rc_country.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = CountryAdapter {
            launcherActivity<NextActivity> {
                putExtra(Constant.EXTRA_RESULT, it)
            }
        }
        val data=repo.getData("cities.json")
        adapter.updateData(data)
        rc_country.adapter = adapter
    }



}
