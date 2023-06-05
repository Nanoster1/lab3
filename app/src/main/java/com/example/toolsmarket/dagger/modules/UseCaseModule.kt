package com.example.toolsmarket.dagger.modules

import com.example.toolsmarket.useCases.interfaces.IUseCase
import com.example.toolsmarket.useCases.realizations.UseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {
    @Binds
    abstract fun getUseCase(useCase: UseCase): IUseCase
}