package com.labs.apptarefas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.labs.apptarefas.ui.theme.ApptarefasTheme
import com.labs.apptarefas.ui.theme.Purple700
import com.labs.apptarefas.ui.theme.WHITE
import com.labs.apptarefas.view.ListaTarefas
import com.labs.apptarefas.view.SalvarTarefa

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController();
            ApptarefasTheme {

                NavHost(navController = navController, startDestination = "listaTarefas"){
                    composable(route = "listaTarefas"){
                        ListaTarefas(navController)
                    }

                    composable(route = "salvarTarefa"){
                        SalvarTarefa(navController)
                    }
                }
            }
        }
    }
}
