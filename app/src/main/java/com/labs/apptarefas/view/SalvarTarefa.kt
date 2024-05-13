package com.labs.apptarefas.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.labs.apptarefas.components.Botao
import com.labs.apptarefas.components.CaixaDeTexto
import com.labs.apptarefas.constants.Constants
import com.labs.apptarefas.repository.TarefaRepository
import com.labs.apptarefas.ui.theme.Purple700
import com.labs.apptarefas.ui.theme.WHITE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarTarefa(
    navController: NavController
){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val tarefaRepository: TarefaRepository = TarefaRepository()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple700,
                ),
                title = {
                    Text(
                        text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                },
            )
        }
    ){

        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        var semPrioridade by remember {
            mutableStateOf(false)
        }

        var prioridadeBaixa by remember {
            mutableStateOf(false)
        }

        var prioridadeMedia by remember {
            mutableStateOf( false)
        }

        var prioridadeAlta by remember {
            mutableStateOf(false)
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                value = tituloTarefa,
                onValueChanged = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 0.dp),
                label = "Titulo Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = descricaoTarefa,
                onValueChanged = {
                    descricaoTarefa = it
                },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Descrição",
                maxLines = 3,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(text = "Nivel de prioridade")

                RadioButton(
                    selected = prioridadeBaixa,
                    onClick = {
                        prioridadeBaixa = !prioridadeBaixa
                        prioridadeMedia = semPrioridade
                        prioridadeAlta = semPrioridade
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.Green,
                        selectedColor = Color.Green
                    )
                )

                RadioButton(
                    selected = prioridadeMedia,
                    onClick = {
                        prioridadeMedia = !prioridadeMedia
                        prioridadeBaixa = semPrioridade
                        prioridadeAlta = semPrioridade
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.Yellow,
                        selectedColor = Color.Yellow
                    )
                )

                RadioButton(
                    selected = prioridadeAlta,
                    onClick = {
                        prioridadeAlta = !prioridadeAlta
                        prioridadeMedia = semPrioridade
                        prioridadeBaixa = semPrioridade
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.Red,
                        selectedColor = Color.Red
                    )
                )
            }
            
            Botao(
                onClick = {
                    var mensagem: Boolean = true

                    scope.launch(Dispatchers.IO){
                        if(tituloTarefa.isEmpty()){
                            mensagem = false
                        } else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && prioridadeBaixa){
                            tarefaRepository.salvarTarefa(tituloTarefa.toString(), descricaoTarefa.toString(), Constants.PRIORIDADE_BAIXA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && prioridadeMedia){
                            tarefaRepository.salvarTarefa(tituloTarefa.toString(), descricaoTarefa.toString(), Constants.PRIORIDADE_MEDIA)
                            mensagem = true
                        }else if (tituloTarefa.isNotEmpty() && descricaoTarefa.isNotEmpty() && prioridadeAlta){
                            tarefaRepository.salvarTarefa(tituloTarefa.toString(), descricaoTarefa.toString(), Constants.PRIORIDADE_ALTA)
                            mensagem = true
                        }
                    }

                    scope.launch(Dispatchers.Main){
                        if(mensagem){
                            Toast.makeText(context, "Sucesso ao salvar tarefa", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Titulo da tarefa é obrigatorio", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                text = "Salvar")

        }

    }
}
