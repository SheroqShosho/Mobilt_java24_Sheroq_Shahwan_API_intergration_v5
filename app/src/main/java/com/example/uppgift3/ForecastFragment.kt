package com.example.uppgift3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.uppgift3.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForecastFragment : Fragment() {

    private lateinit var tvTitle: TextView
    private lateinit var tvTemperature: TextView
    private lateinit var tvWindspeed: TextView

    private var currentLat = 59.33
    private var currentLon = 18.06
    private var cityName = "Stockholm, Sweden"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_forecast, container, false)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvTemperature = view.findViewById(R.id.tvTemperature)
        tvWindspeed = view.findViewById(R.id.tvWindspeed)

        arguments?.let {
            currentLat = it.getDouble("lat", currentLat)
            currentLon = it.getDouble("lon", currentLon)
            cityName = it.getString("cityName", cityName)
        }

        tvTitle.text = "Weather: $cityName"
        fetchWeather(currentLat, currentLon)
        return view
    }

    private fun fetchWeather(latitude: Double, longitude: Double) {
        lifecycleScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getWeather(latitude, longitude)
                }
                tvTemperature.text = "Temperature: ${response.current_weather.temperature} °C"
                tvWindspeed.text = "Windspeed: ${response.current_weather.windspeed} km/h"
            } catch (e: Exception) {
                tvTemperature.text = "Error fetching weather"
                tvWindspeed.text = ""
            }
        }
    }
}
