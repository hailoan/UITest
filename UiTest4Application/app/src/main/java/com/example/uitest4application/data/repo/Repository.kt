package com.example.uitest4application.data.repo

import android.content.Context
import com.example.uitest4application.data.model.City
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Repository(private val context: Context) {

    private fun readAsset(name: String): String {
        var reader: BufferedReader? = null
        val builder = StringBuilder()
        try {
            reader = BufferedReader(InputStreamReader(context.assets.open(name)))
            var line = reader.readLine()
            while (line != null) {
                builder.append(line)
                line = reader.readLine()
            }
        } catch (e: IOException) {
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                }
            }
        }
        return builder.toString()
    }

    fun getData(name: String): List<City> {
        val json = readAsset(name)
        val data: List<City> = ArrayList()
        val arrJsonValue = JSONObject(json)
        val arrJson = arrJsonValue.getString("Cities")
        val jsonArr = JSONArray(arrJson)
        for (i in 0 until jsonArr.length()) {
            val valueJson = jsonArr.getJSONObject(i)
            val city =
                City(
                    valueJson.getString(
                        "Name"
                    )
                )
            (data as ArrayList).add(city)
        }
        return data
    }
}