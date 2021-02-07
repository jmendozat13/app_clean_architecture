package com.afoxplus.appdemo.ui.main

import android.content.Context
import android.content.Intent
import com.afoxplus.appdemo.databinding.ActivityMainBinding
import com.afoxplus.appdemo.ui.BaseActivity
import com.afoxplus.appdemo.ui.chat.ChatBotActivity

class MainActivity : BaseActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate() {
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)
        setUpView()
    }

    override fun setUpView() = with(bindingMainActivity) {
        webView.loadUrl("https://www.android.com/")
        chatBotFloating.setOnClickListener {
            ChatBotActivity.start(this@MainActivity)
        }
    }

    override fun viewModelObserver() {
        //Do nothing
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}