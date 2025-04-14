package com.estsoft.orbitmvidemo.ui

import com.estsoft.orbitmvidemo.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : BaseViewModel<MainUIState, MainSideEffect>() {
    override val container = container<MainUIState, MainSideEffect>(
        MainUIState(), buildSettings = {
            exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                throwable.printStackTrace()
            }
        }
    )
}