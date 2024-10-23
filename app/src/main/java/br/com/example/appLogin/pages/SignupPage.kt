package br.com.example.appLogin.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.example.appLogin.components.CustomButton
import br.com.example.appLogin.components.CustomInput
import br.com.example.appLogin.users

fun addUser(name: String, email: String, password: String) {
    val newUser = mapOf(
        "name" to name,
        "email" to email,
        "password" to password
    )
    users.add(newUser)
}

@Composable
fun SignupPage(navController: NavController) {
    var email by remember { mutableStateOf("") };
    var name by remember { mutableStateOf("") };
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Spacer(Modifier.size(32.dp));
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    modifier = Modifier.padding(0.dp),
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Voltar"
                    )
                };
                Text(
                    text = "Cadastro",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(Modifier.size(16.dp));
            CustomInput (
                value = name,
                label = "Nome",
                onValueChange = { newValue -> name = newValue }
            );
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
            Spacer(Modifier.size(48.dp));
            CustomButton(
                title = "Cadastrar",
                primary = true,
                onClick = {
                    addUser(name, email, password)
                }
            );
        }
    }
}