package com.swallow.kmmrickandmorty.android.presentation.locations.model

data class Locations(
    val id: Long,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)