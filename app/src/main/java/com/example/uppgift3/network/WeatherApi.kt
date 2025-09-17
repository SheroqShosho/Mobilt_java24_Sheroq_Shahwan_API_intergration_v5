// MyWeatherApi.kt
package com.example.uppgift3.network

import retrofit2.http.GET
import retrofit2.http.Query

data class MyCurrentWeather(val temperature: Double, val windspeed: Double)
data class MyWeatherResponse(val current_weather: MyCurrentWeather)

interface MyWeatherApi {
    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") current_weather: Boolean = true
    ): MyWeatherResponse
}
