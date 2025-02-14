package com.hfad.probaproff

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

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
                    .padding(top = 20.dp)
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
                )
            }
            // Привет!
            Text(
                text = "Привет!",
                fontSize = 32.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )

            // Подзаголовок
            Text(
                text = "Заполните Свои данные или продолжите через социальные медиа",
                fontSize = 18.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp, bottom = 24.dp)
                    .width(271.dp)
            )

            // Email Label
            Text(
                text = "Email",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Email Input
            fun isValidEmail(email: String): Boolean {
                val pattern = """^[a-z0-9]+@[a-z0-9]+\.[a-z]{3,}$""".toRegex()
                return pattern.matches(email)
            }

            Column(

            ) {
                TextField(
                    value = email,
                    onValueChange = { newText ->
                        email = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFE0E0E0),
                        unfocusedContainerColor = Color(0xFFE0E0E0),
                        disabledContainerColor = Color(0xFFE0E0E0),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray
                    ),
                    placeholder = { Text("xyz@gmail.com", color = Color.Gray) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }
            // Пароль Label
            Text(
                text = "Пароль",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            // Пароль Input
            TextField(
                value = password, // Используем переменную состояния
                onValueChange = { newText -> // Обновляем состояние при вводе
                    password = newText
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFE0E0E0),
                    unfocusedContainerColor = Color(0xFFE0E0E0),
                    disabledContainerColor = Color(0xFFE0E0E0),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray
                ),
                placeholder = { Text("Введите пароль", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(
                            painter = if (passwordVisible) painterResource(id = R.drawable.eyepocaz) else painterResource(
                                id = R.drawable.eye
                            ),
                            contentDescription = if (passwordVisible) "Скрыть пароль" else "Показать пароль",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )

            // Восстановить
            Text(
                text = "Восстановить",
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp)
                    .clickable {
                        navController.navigate("FORGET_PASSWORD")
                    }
            )

            // Кнопка входа
            Button(
                onClick = {
                    if (isValidEmail(email)) {
                        navController.navigate("HOME")
                    } else {
                        errorMessage = "Некорректный формат email. Используйте только строчные буквы и цифры."
                        showError = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.parseColor("#03A9F4"))
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Войти",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            // Диалоговое окно с ошибкой
            if (showError) {
                AlertDialog(
                    onDismissRequest = { showError = false },
                    title = { Text("Ошибка") },
                    text = { Text(errorMessage) },
                    confirmButton = {
                        TextButton(onClick = { showError = false }) {
                            Text("OK")
                        }
                    }
                )
            }



            // Создание пользователя
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Вы впервые?",
                    color = Color.Gray,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Создать пользователя",
                    color = Color.Black,
                    fontSize = 17.sp,
                    modifier = Modifier.clickable {
                        navController.navigate("REGISTR")
                    }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    ProbaProffTheme{
       val navController = rememberNavController()
        LoginScreen(navController = navController)

    }
}