package com.labs.apptarefas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Botao(
    onClick: () -> Unit,
    modifier:  Modifier,
    text: String

){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Cyan,
            contentColor = Color.White
        )

    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
    
}
