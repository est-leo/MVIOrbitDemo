package com.estsoft.orbitmvidemo.ui

import android.util.Log
import com.estsoft.orbitmvidemo.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
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
                    Log.d("devsim","IntentA - 1")
                    delay(100)
                    Log.d("devsim","IntentA - 2")
                    reduce {
                        state.copy(count = 3)
                    }
                }
            }

            MainIntent.IntentB -> {
                intent {
                    Log.d("devsim","IntentB - 1")
                    delay(10)
                    Log.d("devsim","IntentB - 2")
                    reduce {
                        state.copy(count = 5)
                    }
                }
            }
        }
    }
}