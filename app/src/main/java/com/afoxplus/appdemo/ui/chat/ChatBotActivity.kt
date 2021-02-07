package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.afoxplus.appdemo.R
import com.afoxplus.appdemo.databinding.ActivityChatbotBinding
import com.afoxplus.appdemo.ui.BaseActivity


class ChatBotActivity : BaseActivity() {
    private lateinit var bindingChatBot: ActivityChatbotBinding
    private lateinit var viewModel: ChatBotViewModel
    private val adapter: ChatBotAdapter by lazy { ChatBotAdapter() }

    override fun onCreate() {
        bindingChatBot = ActivityChatbotBinding.inflate(layoutInflater)
        bindingChatBot.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(ChatBotViewModel::class.java)
        bindingChatBot.adapter = adapter
        bindingChatBot.viewModel = viewModel
        setContentView(bindingChatBot.root)
    }

    override fun setUpView() {
        bindingChatBot.toolbar.textTitle.text = getString(R.string.home_chat_description)
        bindingChatBot.toolbar.btnBack.setOnClickListener { onBackPressed() }
    }

    override fun viewModelObserver() {
        viewModel.allMessages.observe(this) { adapter.submitList(it) }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatBotActivity::class.java)
            context.startActivity(intent)
        }
    }
}