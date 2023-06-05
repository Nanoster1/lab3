package com.example.toolsmarket.dagger

import com.example.toolsmarket.ToolsFragment
import com.example.toolsmarket.dagger.modules.NetworkModule
import com.example.toolsmarket.dagger.modules.RepositoryModule
import com.example.toolsmarket.dagger.modules.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, UseCaseModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(toolsFragment: ToolsFragment)
}