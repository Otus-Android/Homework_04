package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.application.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
  @ApplicationContext private val context: Context,
  private val source: MutableStateFlow<Int>
) {

  private val scope = CoroutineScope(Job() + Dispatchers.Main)

  fun observeColors(callback: (Int) -> Unit) {
    if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
    Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    scope.launch {
      source.collect {
        callback(it)
      }
    }
  }

  fun clear() {
    scope.cancel()
  }
}