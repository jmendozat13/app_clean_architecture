package com.afoxplus.appdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setMainView()
    abstract fun setUpView()
    abstract fun viewModelObserver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMainView()
        setUpView()
        viewModelObserver()
    }
}