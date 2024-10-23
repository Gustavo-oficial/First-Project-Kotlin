package br.com.example.appLogin.pages

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.example.appLogin.components.CustomButton
import br.com.example.appLogin.components.CustomInput

@Composable
fun LoginPage(navController: NavController){
    var email by remember { mutableStateOf("") };
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val bitmap = BitmapFactory.decodeStream(context.assets.open("images/logo.jpg"))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Top
        ){
            Spacer(Modifier.size(48.dp));
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )
            Spacer(Modifier.size(48.dp));
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                CustomInput (
                    value = email,
                    label = "E-mail",
                    onValueChange = { newValue -> email = newValue }
                );
                CustomInput (
                    value = password,
                    label = "Senha",
                    onValueChange = { newValue -> password = newValue }
                );
            }
            Spacer(Modifier.size(12.dp));
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ){
                Text(
                    text = "Esqueceu a senha?",
                    textAlign = TextAlign.End
                )
            }
            Spacer(Modifier.size(48.dp));
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                CustomButton(
                    title = "Iniciar Sessao",
                    primary = true,
                    onClick = { navController.navigate("home") }
                );
                CustomButton(
                    title = "Cadastrar-se",
                    primary = false,
                    onClick = { navController.navigate("signup") }
                )
            }
        }
    }
}