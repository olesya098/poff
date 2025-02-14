package com.hfad.probaproff

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme
import kotlinx.coroutines.delay
@Composable
fun Proverka(navController: NavController) {
    var timeLeft by remember { mutableStateOf(30) }
    var prov1 by remember { mutableStateOf("") }
    var prov2 by remember { mutableStateOf("") }
    var prov3 by remember { mutableStateOf("") }
    var prov4 by remember { mutableStateOf("") }
    var prov5 by remember { mutableStateOf("") }
    var prov6 by remember { mutableStateOf("") }

    // Состояние для отслеживания ошибки
    var isError by remember { mutableStateOf(false) }

    // Функция проверки пароля
    fun checkPassword(): Boolean {
        val password = prov1 + prov2 + prov3 + prov4 + prov5 + prov6
        return password != "000000"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(40.dp)
                    .background(
                        Color(0xFFE0E0E0),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(24.dp)
                        .clickable {
                            navController.navigate("LOGIN_SCREEN")
                        }
                )
            }

            Text(
                text = "OTP проверка",
                fontSize = 28.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )

            Text(
                text = "Пожалуйста, проверьте свою электронную почту, чтобы увидеть код подтверждения",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp, bottom = 16.dp)
                    .width(271.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Создаем список полей для упрощения кода
                val fields = listOf(
                    prov1 to { newText: String -> prov1 = newText },
                    prov2 to { newText: String -> prov2 = newText },
                    prov3 to { newText: String -> prov3 = newText },
                    prov4 to { newText: String -> prov4 = newText },
                    prov5 to { newText: String -> prov5 = newText },
                    prov6 to { newText: String -> prov6 = newText }
                )

                fields.forEach { (value, onValueChange) ->
                    TextField(
                        value = value,
                        onValueChange = { newText ->
                            if (newText.length <= 1 && newText.all { it.isDigit() }) {
                                onValueChange(newText)
                            }
                        },
                        modifier = Modifier
                            .width(45.dp)
                            .height(85.dp)
                            .padding(2.dp)
                            .border(
                                width = if (isError) 2.dp else 0.dp,
                                color = if (isError) Color.Red else Color.Transparent,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor =  Color(0xFFE0E0E0),
                            unfocusedContainerColor =  Color(0xFFE0E0E0),
                            disabledContainerColor = Color(0xFFE0E0E0),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedLabelColor = Color.Gray,
                            unfocusedLabelColor = Color.Gray,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Gray
                        ),
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        ),
                        placeholder = {
                            Text(
                                "",
                                color = Color.Gray
                            )
                        }
                    )
                }
            }

            Button(
                onClick = {
                    isError = checkPassword()
                    if (!isError) {
                        navController.navigate("HOME")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.parseColor("#03A9F4"))
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Отправить",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Отправить заново",
                    color = Color.Gray
                )
                Text(
                    text = formatTime(timeLeft),
                    modifier = Modifier.padding(start = 110.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                LaunchedEffect(key1 = Unit) {
                    while (timeLeft > 0) {
                        delay(1000)
                        timeLeft--
                    }
                }
            }
        }
    }
}

fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return "%02d:%02d".format(minutes, remainingSeconds)
}
@Preview(showBackground = true)
@Composable
fun ProverkaPreview(){
    ProbaProffTheme{
        val navController = rememberNavController()
        Proverka(navController = navController)
    }

}