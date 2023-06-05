package com.example.toolsmarket.useCases.interfaces

import com.example.toolsmarket.models.Tool

interface IUseCase {
    suspend fun getTools(): List<Tool>
}