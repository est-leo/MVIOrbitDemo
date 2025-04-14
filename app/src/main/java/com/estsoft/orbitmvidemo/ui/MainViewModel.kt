package com.estsoft.orbitmvidemo.ui

import android.util.Log
import com.estsoft.orbitmvidemo.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
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
    }

    fun post(intent: MainIntent) {
        when (intent) {
            MainIntent.IntentA -> {
                intent {
                    Log.d("devsim", "IntentA - 1 [${Thread.currentThread().name}]")
                    withContext(Dispatchers.Main){
                        //do something
                        Log.d("devsim", "IntentA - 2 [${Thread.currentThread().name}]")
                    }
                    Log.d("devsim", "IntentA - 3 [${Thread.currentThread().name}]")
                    reduce {
                        state.copy(count = 3)
                    }
                }
            }

            MainIntent.IntentB -> {
            }
        }
    }
}
