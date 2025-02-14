package com.hfad.probaproff

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutShoose(navController: NavController,
                collapsedMaxLine: Int = 3) {
    var isExpanded by remember { mutableStateOf(false) }
    val imageList = remember {
        mutableStateListOf(
            Image(
                1,
                R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3

            ),
            Image(
                2,
                R.drawable.nike2

            ),
            Image(
                3,
                R.drawable.nike3

            ),
            Image(
                4,
                R.drawable.nike5

            ),
            Image(
                5,
                R.drawable.nike4

            )
        )

    }
    var selectedImage by remember { mutableStateOf(R.drawable.nike) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(android.graphics.Color.parseColor("#EFEFEF")),
                ),
                modifier = Modifier,
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(40.dp)
                                .background(
                                    Color.White,
                                    shape = CircleShape
                                )

                        ) {
                            IconButton(onClick = {
                                navController.navigate("HOME")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = "",
                                    tint = Color.Black
                                )
                            }
                        }
                        Text(
                            text = "Sneaker Shop",
                            fontSize = 17.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )

                        IconButton(onClick = {}) {
                            Image(
                                painter = painterResource(id = R.drawable.group_27),
                                contentDescription = "",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }


                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
                .fillMaxSize(),
        ) {
            item {
                Text(
                    text = "Nike Air Max 270 \nEssential",
                    fontSize = 30.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = "Men’s Shoes",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(8.dp),
                    color = Color.Gray
                )
                Text(
                    text = "₽179.39",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black,
                    modifier = Modifier.padding(8.dp)
                )

                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp), // Задаём фиксированную высоту для Box
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = selectedImage),
                        contentDescription = "",
                        modifier = Modifier
                            .size(200.dp)
                            .align(Alignment.Center),
                    )
                    Image(
                        painter = painterResource(id = R.drawable.poloska),
                        contentDescription = "",
                        modifier = Modifier
                            .size(250.dp)
                            .align(Alignment.Center)
                            .padding(top = 110.dp)
                    )
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(imageList) { image ->
                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(Color.White, shape = CircleShape)
                                .clickable { selectedImage = image.img }
                        ) {
                            Image(
                                painter = painterResource(id = image.img),
                                contentDescription = "Image ${image.id}",
                                modifier = Modifier
                                    .size(40.dp)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
                Column {
                    Text(//Описание с возможностью разворачивания
                        text = "Вставка Max Air 270 обеспечивает непревзойденный комфорт в течение всего дня. Изящный дизайн делает эти кросовки совершенством.",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
                        overflow = TextOverflow.Ellipsis,//TextOverflow.Ellipsis добавляет многоточие при обрезании
                        modifier = Modifier.padding(12.dp)
                    )

                    Text(
                        text = if (isExpanded) "Свернуть" else "Показать полностью",
                        color = Color(android.graphics.Color.parseColor("#48B2E7")),
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable { isExpanded = !isExpanded }
                            .padding(12.dp),
                        fontSize = 14.sp
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                            .background(
                                Color(android.graphics.Color.parseColor("#EFEFEF")),
                                shape = CircleShape
                            )
                    ) {
                        IconButton(onClick = {
                            navController.navigate("")
                        }) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "",
                                tint = Color.Black
                            )
                        }
                    }
                    Button(
                        onClick = { navController.navigate("") },
                        modifier = Modifier
                            .weight(1f) // Занимает оставшееся пространство
                            .padding(24.dp)
                            .height(54.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(android.graphics.Color.parseColor("#03A9F4"))
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Добавлено",
                            color = Color.White,
                            fontSize = 18.sp,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AboutShoosePreview(){
    ProbaProffTheme{
        val navController = rememberNavController()
        AboutShoose(navController = navController)
    }
}
