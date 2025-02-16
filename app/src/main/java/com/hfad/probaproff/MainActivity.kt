package com.hfad.probaproff

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme


class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        enableEdgeToEdge()

        setContent {
            ProbaProffTheme {
                val navController = rememberNavController()
                NavController(navController)
            }
        }
    }

    @Composable
    fun NavController(navController: NavHostController) {
        Column {
            NavHost(
                navController = navController,
                startDestination = "PRIV",
                modifier = Modifier.background(Color.Transparent)
            ) {
                composable(route = "PRIV") {
                    Priv(navController)
                }
                composable(route = "HOME") {
                    Home(navController)
                }
                composable(route = "LOGIN_SCREEN") {
                    LoginScreen(navController)
                }
                composable(route = "POPULAR") {
                    Popular(navController)
                }
                composable(route = "CATEGORY") {
                    CategoryVse(navController)
                }
                composable(route = "REGISTR") {
                    Registration(navController)
                }
                composable(route = "FORGET_PASSWORD") {
                    ForgetPassword(navController)
                }
                composable(route = "PROVERKA") {
                    Proverka(navController)
                }
                composable(route = "ABOUT") {
                    AboutShoose(navController)
                }
                composable(route = "FAVORITE") {
                    Favorite(navController)
                }
                composable(route = "BASKET") {
                    Basket(navController)
                }
                composable(route = "BASKETZACAZ") {
                    BasketZacaz(navController)
                }
                composable(route = "POISK") {
                    Poisk(navController)
                }
                composable(route = "PROFIL") {
                    Profil(navController)
                }

            }
        }
    }
}



