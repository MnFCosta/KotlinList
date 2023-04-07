package com.example.steamgames.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Game(
    @StringRes val nameStringResId: Int,
    @DrawableRes val imageDrawableResId: Int,
    @StringRes val priceStringResId: Int,
    val isOnOffer: Boolean = false,
)
