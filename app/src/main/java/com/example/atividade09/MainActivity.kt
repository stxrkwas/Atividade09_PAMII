package com.example.atividade09

// Classe para gerenciar o estado da activity
import android.os.Bundle

// Função para habilitar o modo edge-to-edge
import androidx.activity.enableEdgeToEdge

// Componente para criar linhas divisórias
import androidx.compose.material3.Divider

//  Classe para acessar o tema da aplicação
import androidx.compose.material3.MaterialTheme

// Componente para criar uma superfície com estilo
import androidx.compose.material3.Surface

// Componente para exibir texto
import androidx.compose.material3.Text

// Classe base para activities no Jetpack Compose
import androidx.activity.ComponentActivity

// Função para definir o conteúdo da activity
import androidx.activity.compose.setContent

// Componente para exibir imagens
import androidx.compose.foundation.Image

// Modificador para definir a cor de fundo
import androidx.compose.foundation.background

// Modificadores para layout de elementos
import androidx.compose.foundation.layout.*

// Anotation para funções que compõem a UI
import androidx.compose.runtime.Composable

// Classe para alinhamento de elementos
import androidx.compose.ui.Alignment

//  Classe para aplicar modificadores aos elementos da UI
import androidx.compose.ui.Modifier

// Classe para representar cores
import androidx.compose.ui.graphics.Color

// Função para carregar imagens do res/drawable
import androidx.compose.ui.res.painterResource

// Anotation para funções de visualização da UI
import androidx.compose.ui.tooling.preview.Preview

// Classe para definir unidades de medida
import androidx.compose.ui.unit.dp

// Classe para definir unidades de medida para tamanho de texto
import androidx.compose.ui.unit.sp

// Classe para gerenciar elementos de navegação
import androidx.compose.material3.Scaffold

// Classe para definir o tema da aplicação
import com.example.atividade09.ui.theme.Atividade09Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Atividade09Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NewApp()
                }
            }
        }
    }
}

@Composable
fun NewApp() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color())
    ){

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Atividade09Theme {
        Greeting("Android")
    }
}