package com.labs.apptarefas.itemLista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.labs.apptarefas.R
import com.labs.apptarefas.model.Tarefa
import com.labs.apptarefas.ui.theme.ShapeCardPrioridade

@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefa>
) {

    val tituloTarefa = listaTarefas[position].tarefa
    val descricao = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    val nivelPrioridade = when(prioridade){
        0 -> {
            "Sem prioridade"
        }
        1 -> {
            "Prioridade Baixa"
        }
        2 -> {
            "Prioridade Média"
        }
        else -> {
            "Prioridade Alta"
        }
    }

    val color = when(prioridade){
        0 -> Color.Black
        1 -> Color.Green
        2 -> Color.Yellow
        else -> Color.Red
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()

            Text(
                text = tituloTarefa.toString(),
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = descricao.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = nivelPrioridade,
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = color
                ),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCardPrioridade.large
            ) {
            }

            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(btDeletar){
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(cardPrioridade.end, margin = 50.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 20.dp)
                    }
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)

            }
        }
    }
}
