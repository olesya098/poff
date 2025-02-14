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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration (navController: NavController){
    var enemail by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
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
                        .clickable {
                            navController.navigate("LOGIN_SCREEN")
                        }
                )
            }
            // Привет!
            Text(
                text = "Регистрация",
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
            Text(
                text = "Ваше имя",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Email Input
            TextField(
                value = name, // Используем переменную состояния
                onValueChange = { newText -> // Обновляем состояние при вводе
                    name = newText
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
                placeholder = { Text("Введите ваше имя",
                    color = Color.Gray) }
            )

            // Email Label
            Text(
                text = "Email",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
            )

            // Email Input
            TextField(
                value = enemail, // Используем переменную состояния
                onValueChange = { newText -> // Обновляем состояние при вводе
                    enemail = newText
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
                placeholder = { Text("Введите email",
                    color = Color.Gray) }
            )

            // Пароль Label
            Text(
                text = "Пароль",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            TextField(
                value = pass, // Используем переменную состояния
                onValueChange = { newText -> // Обновляем состояние при вводе
                    pass = newText
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
                placeholder = { Text("Введите пароль",
                    color = Color.Gray) }
            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.otm),
                    contentDescription = "",
                    modifier = Modifier.padding(top = 13.dp).size(10.dp)
                )
                // Восстановить
                Text(
                    text = "Даю согласие на обработку персональных данных",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
            }


            // Кнопка входа
            Button(
                onClick = { /* Обработка входа */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(android.graphics.Color.parseColor("#03A9F4")) // Исправлено здесь
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Зарегистрироваться",
                    color = Color.White,
                    fontSize = 18.sp
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
                    text = "Есть аккаунт?",
                    color = Color.Gray,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = " Войти",
                    color = Color.Black,
                    fontSize = 17.sp,
                    modifier = Modifier.clickable {
                        navController.navigate("LOGIN_SCREEN")
                    }
                )
            }
        }
    }
}