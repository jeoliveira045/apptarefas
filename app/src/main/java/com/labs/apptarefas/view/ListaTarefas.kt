package com.labs.apptarefas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.labs.apptarefas.R
import com.labs.apptarefas.datasource.Datasource
import com.labs.apptarefas.itemLista.TarefaItem
import com.labs.apptarefas.model.Tarefa
import com.labs.apptarefas.repository.TarefaRepository
import com.labs.apptarefas.ui.theme.BLACK
import com.labs.apptarefas.ui.theme.Purple700
import com.labs.apptarefas.ui.theme.WHITE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(
    navController: NavController
){

    val tarefaRepository = TarefaRepository()
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
                        color = WHITE,
                    )
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

        var listaTarefas = tarefaRepository.recuperarTarefa().collectAsState(mutableListOf()).value
        LazyColumn(
            userScrollEnabled = true,
            modifier = Modifier.padding(0.dp, 70.dp,0.dp, 0.dp)
        ) {
            itemsIndexed(listaTarefas){ position, _ ->
                TarefaItem(position, listaTarefas)
            }
        }
    }

}
