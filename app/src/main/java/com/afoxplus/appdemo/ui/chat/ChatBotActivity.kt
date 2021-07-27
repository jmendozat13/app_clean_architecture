package com.afoxplus.appdemo.ui.chat

import android.content.Context
import android.content.Intent
import androidx.viewpager2.widget.ViewPager2
import com.afoxplus.appdemo.core.EventObserver
import com.afoxplus.appdemo.core.adapters.ViewPagerAdapter
import com.afoxplus.appdemo.core.extensions.next
import com.afoxplus.appdemo.databinding.ActivityChatbotBinding
import com.afoxplus.appdemo.ui.BaseActivity
import com.afoxplus.appdemo.ui.account.UserViewModel
import com.afoxplus.domain.entities.account.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatBotActivity : BaseActivity() {
    private lateinit var bindingChatBot: ActivityChatbotBinding
    private val viewModel: ChatBotViewModel by viewModel()
    private val userViewModel: UserViewModel by viewModel()
    private val chatUserFragment: ChatUserFragment by lazy { ChatUserFragment() }
    private val chatFragment: ChatFragment by lazy { ChatFragment() }
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun setMainView() {
        bindingChatBot = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(bindingChatBot.root)
    }

    override fun onSetUp() {
        bindingChatBot.toolbar.setNavigationOnClickListener { onBackPressed() }
        userViewModel.getUser()
    }

    override fun onObserverViewModel() {
        viewModel.eventOnContinue.observe(this, EventObserver { userName ->
            userViewModel.saveUserByName(userName)
            viewModel.user = User(name = userName)
            bindingChatBot.viewPager.next()
            viewPagerAdapter.deletePrevious()
        })
        userViewModel.user.observe(this) { user ->
            if(user != null) viewModel.user = user
            setUpChatViewPager(user)
        }
    }

    private fun setUpChatViewPager(user: User?) {
        val fragments =
            user?.let { arrayListOf(chatFragment) } ?: arrayListOf(chatUserFragment, chatFragment)
        viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            lifecycle,
            fragments
        )
        bindingChatBot.viewPager.run {
            adapter = viewPagerAdapter
            isUserInputEnabled = false
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChatBotActivity::class.java)
            context.startActivity(intent)
        }
    }
}