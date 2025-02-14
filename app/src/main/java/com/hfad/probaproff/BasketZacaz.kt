package com.hfad.probaproff

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketZacaz(navController: NavController) {
    var email by remember { mutableStateOf("Email") }
    var phone by remember { mutableStateOf("Телефон") }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        // Используем BasketBar2 в качестве нижней панели навигации
        bottomBar = {
            BasketBar2(navController = navController)
        },
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                ),
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(40.dp)
                                .background(Color.White, shape = CircleShape)
                        ) {
                            IconButton(onClick = { navController.navigate("HOME") }) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = "",
                                    tint = Color.Black
                                )
                            }
                        }

                        Text(
                            text = "Корзина",
                            fontSize = 17.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 80.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
        ) {
            ContactCard(
                email = email,
                phone = phone,
                onEmailChange = { email = it },
                onPhoneChange = { phone = it }
            )
        }
    }
}

@Composable
fun ContactCard(
    email: String,
    phone: String,

    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit
) {
    var isEditable by remember { mutableStateOf(false) }
    var isEditable2 by remember { mutableStateOf(false) }
    var isEditMode by remember { mutableStateOf(true) }
    var isEditModeDob by remember { mutableStateOf(true) }
    var star by remember { mutableStateOf("********") }



    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .fillMaxSize()
            .padding(8.dp)

    ) {
        Text(
            text = "Контактная информация",
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color.Black
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }

            BasicTextField(
                value = email,
                textStyle = TextStyle(color = Color.Gray),
                onValueChange = { if (isEditable) onEmailChange(it) },
                enabled = isEditable,
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent)
                    .padding(8.dp),
                decorationBox = { innerTextField ->
                    Column {
                        Text(
                            text = "emmanuel@gmail.com",
                            color = Color.Black,
                        )
                        innerTextField()
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            IconButton(onClick = { isEditable = !isEditable }) {
                Icon(
                    imageVector = if (isEditable) Icons.Default.Done else Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }

            BasicTextField(
                value = phone,
                textStyle = TextStyle(color = Color.Gray),
                onValueChange = { if (isEditable2) onPhoneChange(it) },
                enabled = isEditable2,
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent)
                    .padding(8.dp),
                decorationBox = { innerTextField ->
                    Column {
                        Text(
                            text = "+234-811-732-5298",
                            color = Color.Black,
                            style = TextStyle(fontStyle = FontStyle.Italic),
                        )
                        innerTextField()
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            IconButton(onClick = { isEditable2 = !isEditable2 }) {
                Icon(
                    imageVector = if (isEditable2) Icons.Default.Done else Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }

        // Секция адреса
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Адрес",
            color = Color.Black,
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "1082 Аэропорт, Нигерии",
                color = Color.Black
            )

            IconButton(onClick = { isEditMode = !isEditMode }) {
                Icon(
                    imageVector = if (isEditMode) Icons.Default.Edit else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.karta),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // Затемняющий слой
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f),  shape = RoundedCornerShape(16.dp)) // Здесь вы можете регулировать значение alpha для изменения степени затемнения
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Посмотреть на карте",
                    modifier = Modifier
                        .padding(16.dp),
                    color = Color.White,

                )
                Spacer(modifier = Modifier.height(6.dp))
                Image(
                    painter = painterResource(id = R.drawable.mesto),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(60.dp),
                )

            }


        }

        Text(
            text = "Способ оплаты"
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            ) {
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.oplata),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

            BasicTextField(
                value = star,
                textStyle = TextStyle(color = Color.Gray),
                onValueChange = { if (isEditable2) onPhoneChange(it) },
                enabled = isEditable2,

                modifier = Modifier
                    .weight(1f)
                    .background(Color.Transparent)
                    .padding(8.dp),
                decorationBox = { innerTextField ->
                    Column {
                        Text(
                            text = "Добавить",
                            color = Color.Black,
                            style = TextStyle(fontStyle = FontStyle.Italic),
                        )
                        innerTextField()
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }


    }

}

@Composable
fun BasketBar2(navController: NavController) {
    var show by remember { mutableStateOf(false) }

    // Удаляем пустой NavigationBar и Box
    Column(
        modifier = Modifier
            .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            .fillMaxWidth()
            .padding(
                start = 12.dp,
                end = 12.dp,
                bottom = 12.dp,
                top = 12.dp
            )
    ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween // Распределяет элементы по краям
            ) {
                Text(
                    text = "Сумма",
                    color = Color.Black
                )
                Text(
                    text = "₽753.95",
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Доставка",
                    color = Color.Black
                )
                Text(
                    text = "₽60.20",
                    color = Color.Black
                )
            }
            Text(
                text = "---------------------------------------------------------------------",
                color = Color.Gray,
                modifier = Modifier.padding(start = 12.dp, end = 12.dp)

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Итого",
                    color = Color.Black
                )
                Text(
                    text = "₽814.15",
                    color = Color(android.graphics.Color.parseColor("#48B2E7"))
                )
            }

        Button(
            onClick = { show = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#03A9F4"))
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Оформить заказ",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        OrderScreen(
            show = show,
            onDismiss = { show = false },
            navController = navController
        )
    }
}
@Composable
fun OrderScreen(
    show: Boolean,
    onDismiss: () -> Unit,
    navController: NavController
) {
    if (show) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            AlertDialog(
                onDismissRequest = onDismiss,
                containerColor = Color.White,
                titleContentColor = Color.Black,
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.zakazoformlen),
                        contentDescription = null
                    )
                },
                title = {
                    Text(
                        text = "Вы успешно оформили заказ",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            onDismiss()
                            navController.navigate("HOME")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp)
                            .height(54.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(android.graphics.Color.parseColor("#03A9F4"))
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Вернуться к покупкам",
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }


                },
                dismissButton = {

                }
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun BasketZacazPreview() {
    ProbaProffTheme {
        val navController = rememberNavController()
        BasketZacaz(navController = navController)
    }
}