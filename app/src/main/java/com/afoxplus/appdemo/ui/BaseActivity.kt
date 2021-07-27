package com.afoxplus.appdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), OnSetUpView, OnObserverViewModel {
    abstract fun setMainView()
    override fun onSetUp() {}
    override fun onObserverViewModel() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMainView()
        onSetUp()
        onObserverViewModel()
    }
}