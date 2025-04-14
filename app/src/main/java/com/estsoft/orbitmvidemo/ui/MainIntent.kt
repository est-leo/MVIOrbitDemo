package com.estsoft.orbitmvidemo.ui

sealed class MainIntent {
    data class ChangeTextField(val text: String) : MainIntent()
}