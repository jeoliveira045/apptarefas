package com.labs.apptarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.labs.apptarefas.R
import com.labs.apptarefas.model.Tarefa
import com.labs.apptarefas.ui.theme.BLACK
import com.labs.apptarefas.ui.theme.Purple700
import com.labs.apptarefas.ui.theme.WHITE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(
    navController: NavController
){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple700,
                ),
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE)
                },
            )
        },
        containerColor = Color.Black,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          navController.navigate("salvarTarefa")
                },
                containerColor = Purple700) {
                Image(
                    imageVector =  ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Icone de salvar Tarefa"
                )
            }
        }

    ) {
        var listaTarefas = mutableListOf(
            Tarefa(
                tarefa = "Tarefa 1",
                descricao = "",
                prioridade = 0
            ),
            Tarefa(
                tarefa = "Tarefa 2",
                descricao = "",
                prioridade = 1
            ),
            Tarefa(
                tarefa = "Tarefa 3",
                descricao = "",
                prioridade = 2
            ),
            Tarefa(
                tarefa = "Tarefa 4",
                descricao = "",
                prioridade = 3
            )
        )
    }

}
