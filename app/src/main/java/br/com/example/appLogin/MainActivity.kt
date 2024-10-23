package br.com.example.appLogin

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import br.com.example.appLogin.pages.LoginPage
import br.com.example.appLogin.pages.SignupPage
import br.com.example.appLogin.ui.theme.AplicativoLoginTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.example.appLogin.pages.HomePage

val users: MutableList<Map<String, String>> = mutableListOf(
    mapOf(
        "name" to "Gustavo",
        "email" to "email@emai.com",
        "password" to "1234"
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicativoLoginTheme {
                Scaffold { paddingValues ->
                    App(paddingValues)
                }
            }
        }
    }
}

@Composable
fun App(paddingValues: PaddingValues){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("signup") { SignupPage(navController) }
        composable("home") { HomePage(navController) }
    }
}