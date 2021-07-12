package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.content.Intent
import androidx.viewpager2.widget.ViewPager2
import com.afoxplus.appdemo.core.EventObserver
import com.afoxplus.appdemo.core.adapters.ViewPagerAdapter
import com.afoxplus.appdemo.databinding.ActivityChatbotBinding
import com.afoxplus.appdemo.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatBotActivity : BaseActivity() {
    private lateinit var bindingChatBot: ActivityChatbotBinding
    private val viewModel: ChatBotViewModel by viewModel()
    private val chatUserFragment: ChatUserFragment by lazy { ChatUserFragment() }
    private val chatFragment: ChatFragment by lazy { ChatFragment() }
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun setMainView() {
        bindingChatBot = ActivityChatbotBinding.inflate(layoutInflater)
        bindingChatBot.lifecycleOwner = this
        setContentView(bindingChatBot.root)
    }

    override fun setUpView() {
        bindingChatBot.toolbar.setNavigationOnClickListener { onBackPressed() }
        viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            lifecycle,
            arrayListOf(chatUserFragment, chatFragment)
        )
        bindingChatBot.viewPager.run {
            adapter = viewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    override fun viewModelObserver() {
        viewModel.eventOnContinue.observe(this, EventObserver {
            bindingChatBot.viewPager.currentItem += 1
            viewPagerAdapter.deleteFragment(0)
        })
    }


    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatBotActivity::class.java)
            context.startActivity(intent)
        }
    }
}