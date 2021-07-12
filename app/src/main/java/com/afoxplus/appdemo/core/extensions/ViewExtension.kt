package com.afoxplus.appdemo.core.extensions

import android.view.View
import androidx.viewpager2.widget.ViewPager2

fun View.visible() = run { visibility = View.VISIBLE }
fun View.gone() = run { visibility = View.GONE }

fun ViewPager2.next() {
    try {
        currentItem += 1
    } catch (ex: Exception) {
        //Do nothing
    }
}