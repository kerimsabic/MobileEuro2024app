package com.example.euro24application.model

import androidx.annotation.DrawableRes

data class Team(
    val position:Int,
    val name: String,
    val played: Int,
    val goalDif: Int,
    val points: Int,
    @DrawableRes val flag:Int,

)
