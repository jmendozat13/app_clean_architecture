package com.afoxplus.appdemo.ui.splash


import androidx.lifecycle.lifecycleScope
import com.afoxplus.appdemo.databinding.ActivitySplashBinding
import com.afoxplus.appdemo.ui.BaseActivity
import com.afoxplus.appdemo.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//val = inmutable
//var = mutable

class SplashActivity : BaseActivity() {

    //private var myVariable: String? = null

    private lateinit  var bindingSplashActivity: ActivitySplashBinding
    override fun onCreate() {
        bindingSplashActivity = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bindingSplashActivity.root)

        lifecycleScope.launch(Dispatchers.Main) {
            delay(4000)
            finish()
            MainActivity.start(this@SplashActivity)
            //hacerAlgo(myVariable)
        }
    }

    /*private fun hacerAlgo(cadena: String?) {
        cadena?.let { nuevaVariable: String ->
            println(nuevaVariable)
        } ?: println("Es nulo")
        // let - it
        // run
        // apply
        // when
    }*/
}