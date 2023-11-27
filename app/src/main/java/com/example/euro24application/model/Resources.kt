package com.example.euro24application.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resources (
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val image:Int,
    val age: Int,
    @DrawableRes val imageInfo:Int,
    val teamId: Int,
): Parcelable