package com.afoxplus.appdemo.ui.splash


import androidx.lifecycle.lifecycleScope
import com.afoxplus.appdemo.databinding.ActivitySplashBinding
import com.afoxplus.appdemo.ui.BaseActivity
import com.afoxplus.appdemo.ui.main.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : BaseActivity() {

    private lateinit var bindingSplashActivity: ActivitySplashBinding
    override fun onCreate() {
        bindingSplashActivity = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bindingSplashActivity.root)
        lifecycleScope.launch {
            delay(3000)
            MainActivity.start(this@SplashActivity)
        }
    }


}