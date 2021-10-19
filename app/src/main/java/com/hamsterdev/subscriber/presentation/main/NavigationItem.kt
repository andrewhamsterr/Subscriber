package com.hamsterdev.subscriber.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hamsterdev.subscriber.R

sealed class NavigationItem(val route: String, @DrawableRes val icon: Int, @StringRes val title: Int) {
    object Subscribes : NavigationItem("Subscribes", R.drawable.ic_list, R.string.subscribes)
    object Statistics : NavigationItem("Statistics", R.drawable.ic_stat, R.string.statistics)
    object Settings : NavigationItem("Settings", R.drawable.ic_settings, R.string.settings)
}