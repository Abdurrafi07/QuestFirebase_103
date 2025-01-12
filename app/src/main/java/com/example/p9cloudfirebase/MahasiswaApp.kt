package com.example.p9cloudfirebase

import android.app.Application
import com.example.p9cloudfirebase.DependencisInjections.MahasiswaContainer

class MahasiswaApp : Application(){
    lateinit var containerApp: MahasiswaContainer
    override fun onCreate() {
        super.onCreate()
        containerApp=MahasiswaContainer(this)
    }
}