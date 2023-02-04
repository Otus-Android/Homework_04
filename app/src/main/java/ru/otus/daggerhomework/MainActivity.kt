package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityComponent = (application as App)
            .applicationComponent
            .mainActivityComponent()
            .create()

        //mainActivityComponent.inject(this)

        setContentView(R.layout.activity_main)

    }
}