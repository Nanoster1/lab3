package com.example.toolsmarket.useCases.realizations

import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.repositories.interfaces.IToolRepository
import com.example.toolsmarket.useCases.interfaces.IUseCase
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: IToolRepository) : IUseCase {
    override suspend fun getTools(): List<Tool> {
        return repository.getTools()
    }
}