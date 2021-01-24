package com.afoxplus.appdemo.ui.main

import android.content.Context
import android.content.Intent
import com.afoxplus.appdemo.databinding.ActivityMainBinding
import com.afoxplus.appdemo.ui.BaseActivity

class MainActivity : BaseActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate() {
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)
        setUpView()
    }

    private fun setUpView() = with(bindingMainActivity) {
        webView.loadUrl("http://www.admisionunt.info/")
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }


}