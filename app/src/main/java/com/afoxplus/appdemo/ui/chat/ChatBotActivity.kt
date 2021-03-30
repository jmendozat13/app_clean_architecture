package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.content.Intent
import com.afoxplus.appdemo.R
import com.afoxplus.appdemo.databinding.ActivityChatbotBinding
import com.afoxplus.appdemo.ui.BaseActivity
import com.afoxplus.domain.entities.chat.OptionMessage
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChatBotActivity : BaseActivity() {
    private lateinit var bindingChatBot: ActivityChatbotBinding
    private val viewModel: ChatBotViewModel by viewModel()
    private val adapter: ChatBotAdapter by lazy { ChatBotAdapter() }

    override fun onCreate() {
        bindingChatBot = ActivityChatbotBinding.inflate(layoutInflater)
        bindingChatBot.lifecycleOwner = this
        bindingChatBot.adapter = adapter
        bindingChatBot.viewModel = viewModel
        setContentView(bindingChatBot.root)
    }

    override fun setUpView() {
        bindingChatBot.toolbar.textTitle.text = getString(R.string.home_chat_description)
        bindingChatBot.toolbar.btnBack.setOnClickListener { onBackPressed() }
        adapter.setOnClickMessageListener(::onClickMessage)
    }

    override fun viewModelObserver() {
        viewModel.allMessages.observe(this) {
            adapter.submitList(it)
            bindingChatBot.recycler.scrollToPosition(it.size - 1)
        }
    }

    private fun onClickMessage(option: OptionMessage) {
        viewModel.sendOption(option)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatBotActivity::class.java)
            context.startActivity(intent)
        }
    }
}