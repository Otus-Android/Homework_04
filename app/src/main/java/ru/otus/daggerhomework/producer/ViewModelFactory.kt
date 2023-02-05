package ru.otus.daggerhomework.producer

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.components.DataModule
import ru.otus.daggerhomework.components.State
import javax.inject.Inject
import javax.inject.Named

class ViewModelFactory @Inject constructor(
    @Named("ActivityContext") private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorFlow: MutableSharedFlow<Int>,
    private val stateFlow: MutableStateFlow<State>
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelProducer(context, colorGenerator, colorFlow, stateFlow) as T
}