package com.labs.apptarefas.itemLista

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.labs.apptarefas.ui.theme.ShapeCardPrioridade

@Composable
fun TarefaItem() {

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
                text = "Tarefa 1",
                modifier = Modifier.constrainAs(txtTitulo){
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = "Descrição",
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = "Prioridade baixa",
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                ),
                modifier = Modifier.size(30.dp).constrainAs(cardPrioridade){
                    top.linkTo(txtDescricao.bottom)
                    start.linkTo(txtPrioridade.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
                shape = ShapeCardPrioridade.large
            ) {

            }
        }
    }
}

@Preview
@Composable
fun TarefaItemPreview(){
    TarefaItem()
}

