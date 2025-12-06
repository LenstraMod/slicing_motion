package com.example.slicing_motion.ui.pantautanaman

import com.example.slicing_motion.R

data class PlantDataList(
    val imgId : Int,
    val plantName : String,
    val difficulty : String,
    val time : String
)

val plantList = listOf(
    PlantDataList(R.drawable.sayur, "Selada Hidroponik", "Mudah", "Hari ke-1"),
    PlantDataList(R.drawable.sayur, "Bayam Hidroponik", "Mudah", "Hari ke-2"),
    PlantDataList(R.drawable.sayur, "Pakcoy Hidroponik", "Sulit", "Hari ke-3")
)
