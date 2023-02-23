package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    colorReceiver: ColorReceiver
) {

    val colorFlow: StateFlow<Int> = colorReceiver.getColorFlow()

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}