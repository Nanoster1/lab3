package com.example.toolsmarket.repositories.interfaces

import com.example.toolsmarket.models.Tool

interface IToolRepository {
    suspend fun getTools() : List<Tool>
}