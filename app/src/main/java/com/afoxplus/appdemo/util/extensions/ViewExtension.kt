package com.afoxplus.appdemo.util.extensions

import android.view.View

fun View.visible() = run { visibility = View.VISIBLE }
fun View.gone() = run { visibility = View.GONE }