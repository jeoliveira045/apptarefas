package com.labs.apptarefas.datasource

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.labs.apptarefas.model.Tarefa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class Datasource {
    private val db = FirebaseFirestore.getInstance()

    private val _todasAsTarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())

    private val todasAsTarefas: StateFlow<MutableList<Tarefa>> = _todasAsTarefas


    fun salvarTarefa(
        tarefa: String,
        descricao: String,
        prioridade: Int
    ){
        val tarefaMap = hashMapOf(
            "tarefa" to tarefa,
            "descricao" to descricao,
            "prioridade" to prioridade
        )

        db.collection("tarefas").document(tarefa).set(tarefaMap).addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    fun recuperarTarefa(): Flow<MutableList<Tarefa>>{
        val listaDeTarefas: MutableList<Tarefa> = mutableListOf()

        db.collection("tarefas").get().addOnCompleteListener{ querySnapshot ->
            if(querySnapshot.isSuccessful){
                for(documento in querySnapshot.result){
                    val tarefa = documento.toObject(Tarefa::class.java)
                    listaDeTarefas.add(tarefa)
                    _todasAsTarefas.value = listaDeTarefas
                }
            }
        }
        return todasAsTarefas
    }
}
