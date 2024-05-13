package com.labs.apptarefas.repository

import com.labs.apptarefas.datasource.Datasource
import com.labs.apptarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefaRepository() {

    private val dataSource = Datasource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int){
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }

    fun recuperarTarefa(): Flow<MutableList<Tarefa>>{
        return dataSource.recuperarTarefa()
    }
}
