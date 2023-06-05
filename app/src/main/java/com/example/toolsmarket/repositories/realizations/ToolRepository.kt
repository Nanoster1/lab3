package com.example.toolsmarket.repositories.realizations

import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.ToolsApi
import com.example.toolsmarket.repositories.interfaces.IToolRepository
import javax.inject.Inject

class ToolRepository @Inject constructor(private val toolsApi: ToolsApi) : IToolRepository {
    override suspend fun getTools(): List<Tool> {
        val response = toolsApi.getTools()
        if (response.isSuccessful) {
            val responses = response.body()
            val tools = responses?.let { Tool.getTools(it) }
            if (tools != null) return tools
        }
        return listOf()
    }
}