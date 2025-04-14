package com.estsoft.orbitmvidemo

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost

abstract class BaseViewModel<S : Any, E : Any> : ViewModel(), ContainerHost<S, E>
