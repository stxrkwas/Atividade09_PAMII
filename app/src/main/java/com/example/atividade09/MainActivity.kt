package com.example.atividade09

// Classe para gerenciar o estado da activity
import android.os.Bundle

// Classe para exibir mensagens no Logcat
import android.util.Log

import android.nfc.Tag

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

// Componente para exibir um campo de texto
import androidx.compose.material3.TextField

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

// Componente para exibir botões
import androidx.compose.material3.Button

// Anotation para funções que compõem a UI
import androidx.compose.runtime.Composable

//
import androidx.compose.runtime.getValue

//
import androidx.compose.runtime.mutableStateOf

//
import androidx.compose.runtime.remember

//
import androidx.compose.runtime.setValue

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

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import com.example.atividade09.ui.theme.DebugButtonColors
import com.example.atividade09.ui.theme.ErrorButtonColors
import com.example.atividade09.ui.theme.InfoButtonColors
import com.example.atividade09.ui.theme.WarningButtonColors

// Classe para definir o tema da aplicação
import com.example.atividade09.ui.theme.Atividade09Theme

// Criando a variável com o valor do TAG
const val TAG = "TestAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Atividade09Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewApp()
                }
            }
        }
    }
}

@Composable
fun NewApp() {

    var username by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 200.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){

        Text(
            text = "Atividade de PAM II",
            color = Color.Black,
            fontSize = 30.sp
        )

        // Adiciona um espaço vertical.
        Spacer(modifier = Modifier.height(10.dp))

        val image = painterResource(R.drawable.logo_etec)
        
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        TextField(
            value = username,
            onValueChange = { novoValor -> username = novoValor},
            label = { Text("Digite seu nome")}
        )

        // Adiciona um espaço vertical.
        Spacer(modifier = Modifier.height(25.dp))

        // Cria os botões
        ActionButton(

            // Define o texto do botão
            text = "Nota 1",

            // Chaam a função que define as cores dos botões
            buttonColors = DebugButtonColors(),

            // Define o tamanho do botão
            modifier = Modifier.fillMaxWidth(0.5f)
        ){
            // Imprime no Logcat o texto do botão
            Log.d(TAG, "$username: Tirou MB!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Adiciona mais um botão
        ActionButton(

            // Define o texto do botão
            text = "Nota 2",

            // Chama a função que define as cores dos botões
            buttonColors = InfoButtonColors(),

            // Define o tamanho do botão
            modifier = Modifier.fillMaxWidth(0.5f)
        ){

            // Imprime no Logcat o texto do botão
            Log.i(TAG, "$username: Tirou B!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Adiciona mais um botão
        ActionButton(

            // Define o texto do botão
            text = "Nota 3",

            // Chama a função que define as cores dos botões
            buttonColors = WarningButtonColors(),

            // Define o tamanho do botão
            modifier = Modifier.fillMaxWidth(0.5f)
        ){

            // Imprime no Logcat o texto do botão
            Log.w(TAG, "$username: Tirou R!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Adiciona mais um botão
        ActionButton(

            // Define o texto do botão
            text = "Nota 4",

            // Chama a função que define as cores dos botões
            buttonColors = ErrorButtonColors(),

            // Define o tamanho do botão
            modifier = Modifier.fillMaxWidth(0.5f)
        ){

            // Lê o conteúdo do botão e lança uma exceção
            try{

                // Cria uma exceção
                throw RuntimeException("Tirou I!")

            }

            // Captura a exceção
            catch(ex: Exception){

                // Imprime no Logcat a exceção
                Log.e(TAG, "$username: ${ex.message}")
            }
        }
    }
}

@Composable
fun ActionButton(

    // Declara as variáveis
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){

    // Define o tipo do botão
    ElevatedButton(

        // Define a ação do botão
        onClick = block,

        // Define a forma do botão
        shape = RoundedCornerShape(10.dp),

        // Define as cores do botão
        colors = buttonColors,

        // Define o tamanho do botão
        modifier = modifier
    ) {

        // Exibe o texto do botão
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Atividade09Theme {
        NewApp()
    }
}