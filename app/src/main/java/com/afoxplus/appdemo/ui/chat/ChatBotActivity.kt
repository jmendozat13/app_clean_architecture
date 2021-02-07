package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.afoxplus.appdemo.databinding.ActivityChatbotBinding
import com.afoxplus.appdemo.ui.BaseActivity


class ChatBotActivity : BaseActivity() {
    private lateinit var bindingChatBot: ActivityChatbotBinding
    private lateinit var viewModel: ChatBotViewModel

    override fun onCreate() {
        bindingChatBot = ActivityChatbotBinding.inflate(layoutInflater)
        bindingChatBot.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(ChatBotViewModel::class.java)
        setContentView(bindingChatBot.root)
    }

    override fun setUpView() {
        //Do nothing
    }

    override fun viewModelObserver() {
        viewModel.allMessages.observe(this) { it.forEach { item -> Log.d("TAG", "$item") } }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatBotActivity::class.java)
            context.startActivity(intent)
        }
    }


}