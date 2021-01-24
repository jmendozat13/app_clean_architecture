package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.content.Intent
import com.afoxplus.appdemo.databinding.ActivityChatbotBinding
import com.afoxplus.appdemo.ui.BaseActivity

class ChatBotActivity : BaseActivity() {
    private lateinit var bindingChatBot: ActivityChatbotBinding

    override fun onCreate() {
        bindingChatBot = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(bindingChatBot.root)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatBotActivity::class.java)
            context.startActivity(intent)
        }
    }


}