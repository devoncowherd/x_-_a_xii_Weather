package com.example.weatherapp.ReverseGeocoding


import com.google.gson.annotations.SerializedName

data class Bounds(
    val northeast: Northeast,
    val southwest: Southwest
)