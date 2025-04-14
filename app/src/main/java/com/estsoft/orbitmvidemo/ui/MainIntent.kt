package com.estsoft.orbitmvidemo.ui

sealed class MainIntent {
    object IntentA : MainIntent()
    object IntentB : MainIntent()
}