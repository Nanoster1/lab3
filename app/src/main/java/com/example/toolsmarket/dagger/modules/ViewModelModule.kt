package com.example.toolsmarket.dagger.modules

import androidx.lifecycle.ViewModel
import com.example.toolsmarket.viewModels.ToolsFragmentViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun getToolsFragmentViewModel(toolsFragmentViewModel: ToolsFragmentViewModel) : ToolsFragmentViewModel
}