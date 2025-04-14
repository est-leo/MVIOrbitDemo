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

    init {
        post(MainIntent.IntentA)
        post(MainIntent.IntentB)
    }

    fun post(intent: MainIntent) {
        when (intent) {
            //최종적으로 count는 몇일까?
            MainIntent.IntentA -> {
                intent {
                    reduce {
                        state.copy(count = 1)
                    }
                    post(MainIntent.IntentB)
                    reduce {
                        state.copy(count = 3)
                    }
                }
            }

            MainIntent.IntentB -> {
                intent {
                    reduce {
                        state.copy(count = 2)
                    }
                }
            }
        }
    }
}