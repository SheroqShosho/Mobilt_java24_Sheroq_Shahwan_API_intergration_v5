package com.example.uppgift3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CityListFragment : Fragment() {

    private val cities = mapOf(
        "Stockholm, Sweden" to (59.33 to 18.06),
        "Malmö, Sweden" to (55.605 to 13.0),
        "London, UK" to (51.5072 to -0.1276),
        "New York, USA" to (40.7128 to -74.0060),
        "Tokyo, Japan" to (35.6895 to 139.6917),
        "Paris, France" to (48.8566 to 2.3522),
        "Sydney, Australia" to (-33.8688 to 151.2093)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city_list, container, false)
        val containerLayout = view.findViewById<LinearLayout>(R.id.cityContainer)

        containerLayout.removeAllViews()
        for ((city, coords) in cities) {
            val tv = TextView(requireContext()).apply {
                text = city
                textSize = 18f
                setPadding(8, 16, 8, 16)
                setOnClickListener {
                    val bundle = Bundle().apply {
                        putDouble("lat", coords.first)
                        putDouble("lon", coords.second)
                        putString("cityName", city)
                    }
                    // Navigera via action (uppdaterar nav & backstack korrekt)
                    findNavController().navigate(R.id.action_cityListFragment_to_forecastFragment, bundle)
                }
            }
            containerLayout.addView(tv)
        }
        return view
    }
}
