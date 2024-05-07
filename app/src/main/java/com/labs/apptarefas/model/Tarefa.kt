package com.labs.apptarefas.model

import androidx.compose.runtime.Composable


data class Tarefa(
    val tarefa: String? = null,
    val descricao: String? = null,
    val prioridade: Int? = null
)
