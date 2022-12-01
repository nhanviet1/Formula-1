package com.example.formula1.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import androidx.lifecycle.lifecycleScope
import com.example.formula1.databinding.ActivitySplashBinding
import com.example.formula1.utils.ANIMATION_TIME
import com.example.formula1.utils.DELAY_TIME
import com.example.formula1.utils.base.BaseActivity
import com.example.formula1.view.mainscreen.MainScreen
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setupBackground()
        splashAnimation()
    }

    private fun setupBackground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    private fun splashAnimation() {
        val animation: Animation = AlphaAnimation(1f, 0f)
        animation.duration = ANIMATION_TIME
        animation.interpolator = LinearInterpolator()
        animation.repeatCount = Animation.INFINITE
        animation.repeatMode = Animation.REVERSE
        binding.imgLogo.startAnimation(animation)

       job = lifecycleScope.launch {
            delay(DELAY_TIME)
            startActivity(Intent(this@SplashActivity, MainScreen::class.java))
            finish()
        }
    }

    override fun onStop() {
        job?.cancel()
        super.onStop()
    }
}
