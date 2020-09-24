package com.jdeveloperapps.runnyngapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdeveloperapps.runnyngapp.db.Run
import com.jdeveloperapps.runnyngapp.repositories.MainRepository
import kotlinx.coroutines.launch
class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }


}