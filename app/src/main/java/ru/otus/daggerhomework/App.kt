package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerApplicationComponent
            .factory()
            .create(context = this)
    }
}