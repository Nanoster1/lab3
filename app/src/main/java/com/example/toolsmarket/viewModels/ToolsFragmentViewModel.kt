package com.example.toolsmarket.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.useCases.interfaces.IUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToolsFragmentViewModel @Inject constructor(private val useCase : IUseCase) : ViewModel() {
    val liveData = MutableLiveData<List<Tool>>()
    fun init() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                useCase.getTools()
            }
            liveData.postValue(result)
        }
    }
}