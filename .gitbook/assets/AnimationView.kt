package com.purchasely.demo

import android.animation.ValueAnimator
import android.content.Context
import android.widget.ImageView
import androidx.annotation.Keep
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import io.purchasely.views.template.interfaces.PLYLottieInterface

@Keep
class AnimationView(context: Context) : LottieAnimationView(context), PLYLottieInterface {

    override fun setup(url: String, repeat: Boolean, scaleType: ImageView.ScaleType) {
        setAnimationFromUrl(url)
        enableMergePathsForKitKatAndAbove(true)
        repeatMode = LottieDrawable.RESTART
        repeatCount = if (repeat) ValueAnimator.INFINITE else 0

        this.scaleType = scaleType

        play()
    }

    override fun play() {
        playAnimation()
    }

    override fun stop() {
        pauseAnimation()
    }
}