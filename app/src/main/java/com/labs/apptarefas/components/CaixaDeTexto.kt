package com.labs.apptarefas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.labs.apptarefas.ui.theme.ShapeEditText

@Composable
fun CaixaDeTexto(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = OutlinedTextFieldDefaults.colors(
            disabledTextColor = Color.Black,
            focusedTextColor = Color.Cyan,
            focusedBorderColor = Color.Cyan,
            cursorColor = Color.Cyan,
            disabledContainerColor = Color.White,
            focusedContainerColor = Color.White
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

//@Composable
//@Preview(name = "Preview")
//private fun CaixaDeTextoPreview(){
//    CaixaDeTexto(
//        value = "Marcos",
//        onValueChanged = {},
//        modifier = Modifier.fillMaxWidth(),
//        label = "Nome da tarefa",
//        maxLines = 4
//    )
//}
