package com.estsoft.orbitmvidemo.ui

import androidx.lifecycle.viewModelScope
import com.estsoft.orbitmvidemo.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel : BaseViewModel<MainUIState, MainSideEffect>() {
    override val container = container<MainUIState, MainSideEffect>(
        MainUIState(), buildSettings = {
            exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                throwable.printStackTrace()
            }
        }
    )

    init {
        viewModelScope.launch(Dispatchers.Default) {
            repeat(5000) {
                post(MainIntent.IncreaseNumber)
            }
        }
        viewModelScope.launch(Dispatchers.Default) {
            repeat(5000) {
                post(MainIntent.IncreaseNumber)
            }
        }
        viewModelScope.launch(Dispatchers.Default) {
            repeat(5000) {
                post(MainIntent.IncreaseNumber)
            }
        }
    }

    fun post(intent: MainIntent) {
        when (intent) {
            MainIntent.IncreaseNumber -> {
//                intent {
//                    val count = state.count
//                    delay(1)
//                    val newCount = count + 1
//                    reduce {
//                        state.copy(state.count + 1)
//                    }
//                }
                intent {
                    val count = state.count
                    delay(1)
                    val newCount = count + 1
                    reduce {
                        state.copy(count = newCount)
                    }
                }
            }
        }
    }
}