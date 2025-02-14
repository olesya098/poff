package com.hfad.probaproff

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hfad.probaproff.ui.theme.Gray2
import com.hfad.probaproff.ui.theme.ProbaProffTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profil(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.hamburger),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(30.dp)

                        )
                        Text(
                            text = "Профиль",
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(30.dp)

                        )

                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)

        ) {

            ProfilScreen()

            BottomNavigationBarWithBackground(navController)
        }
    }

}

@Composable
fun ProfilScreen() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profilphoto),
            contentDescription = null,
            modifier = Modifier
                .size(140.dp)
                .padding(15.dp)
        )
        Text(
            text = "Emmanuel Oyiboke",
            fontSize = 20.sp,
            color = Color.Black
        )
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .background(
                    Color(android.graphics.Color.parseColor("#EFEFEF")),
                    shape = RoundedCornerShape(16.dp)
                ),

            ) {
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Открыть",
                    modifier = Modifier.rotate(-90f),
                    color = Color.Black,
                    fontSize = 15.sp
                )
            }
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(60.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.screeeenshot),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),  // Заполнит весь Box
                    contentScale = ContentScale.Fit     // Сохранит пропорции
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Имя",
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(10.dp)
            )
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                modifier = Modifier
                    .height(54.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                    unfocusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                    disabledContainerColor = Color(0xFFE0E0E0),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Gray,
                    unfocusedLabelColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray
                ),
                label = {
                    Text(
                        text = "Emmanuel"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = null,
                        tint = Color(android.graphics.Color.parseColor("#48B2E7"))
                    )
                }
            )
        }
        Text(
            text = "Фамилия",
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                unfocusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                disabledContainerColor = Color(0xFFE0E0E0),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray
            ),
            label = {
                Text(
                    text = "Oyiboke"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    tint = Color(android.graphics.Color.parseColor("#48B2E7"))
                )
            }
        )

        Text(
            text = "Адрес",
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                unfocusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                disabledContainerColor = Color(0xFFE0E0E0),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray
            ),
            label = {
                Text(
                    text = "Nigeria"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    tint = Color(android.graphics.Color.parseColor("#48B2E7"))
                )
            }
        )


        Text(
            text = "Телефон",
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .height(54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                unfocusedContainerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                disabledContainerColor = Color(0xFFE0E0E0),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Gray,
                unfocusedLabelColor = Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray
            ),
            label = {
                Text(
                    text = "+7 811-732-5298"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    tint = Color(android.graphics.Color.parseColor("#48B2E7"))
                )
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ProfilPreview() {
    ProbaProffTheme {
        ProfilScreen()
    }
}