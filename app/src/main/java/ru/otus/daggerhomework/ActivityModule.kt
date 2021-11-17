package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow

@Module
class ActivityModule {

    @ActivityScope
    @Provides
    fun stateObserver(): MutableStateFlow<Int> {
        return MutableStateFlow(0)
    }
}