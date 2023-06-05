package com.example.toolsmarket.dagger.modules

import com.example.toolsmarket.repositories.interfaces.IToolRepository
import com.example.toolsmarket.repositories.realizations.ToolRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun getToolRepository(repository: ToolRepository): IToolRepository
}