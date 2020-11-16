package com.example.background_detection_library

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

open class BackgroundDetectionApplication : Application(), LifecycleObserver{

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onForeground(){
        Toast.makeText(applicationContext,"App Foregrounded", Toast.LENGTH_SHORT).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onBackground(){
        Toast.makeText(applicationContext,"App Backgrounded",Toast.LENGTH_SHORT).show()
    }
}