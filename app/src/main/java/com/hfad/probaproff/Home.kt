package com.hfad.probaproff

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme
import com.hfad.probaproff.ui.theme.White20

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

    val categoryList = remember {
        mutableStateListOf(
            CategoryList("Все"),
            CategoryList("Outdoor"),
            CategoryList("Tennis"),
            CategoryList("Running")
        )
    }
    val categoryListElements = remember {
        mutableStateListOf(
            CategoryElements(
                1,
                R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3,
                "Best Seller",
                "Nike Air Max",
                "₽752.00"
            ),
            CategoryElements(
                2,
                R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3,
                "Best Seller",
                "Nike Air Max",
                "₽752.00"
            ),
            CategoryElements(
                3,
                R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3,
                "Best Seller",
                "Nike Air Max",
                "₽752.00"
            ),
            CategoryElements(
                4,
                R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3,
                "Best Seller",
                "Nike Air Max",
                "₽752.00"
            ),
            CategoryElements(
                5,
                R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3,
                "Best Seller",
                "Nike Air Max",
                "₽752.00"
            ),
        )
    }
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var text2 by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            TopAppBar(
                title = {},  // Очищаем стандартный title
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(),
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Действие при нажатии */ }) {
                            Image(
                                painter = painterResource(id = R.drawable.hamburger),
                                contentDescription = "Home",
                                modifier = Modifier.size(36.dp)
                            )
                        }

                        Text(
                            text = "Главная",
                            fontSize = 32.sp,
                            style = TextStyle(
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        )

                        IconButton(onClick = { /* Действие при нажатии */ }) {
                            Image(
                                painter = painterResource(id = R.drawable.group_27),
                                contentDescription = "Profile",
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                })
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(  // Заменяем внешний Column на LazyColumn
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            ) {
                item {

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(

                            modifier = Modifier
                                .width(280.dp)
                                .padding(10.dp),
                            value = text,
                            maxLines = 1,
                            shape = RoundedCornerShape(20.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.White, // Цвет фона текстового поля, когда оно в фокусе
                                unfocusedContainerColor = Color.White, // Цвет фона текстового поля, когда оно не в фокусе
                                disabledContainerColor = Color.White, // Цвет фона текстового поля, когда оно отключено (disabled)
                                focusedIndicatorColor = Color.Transparent, // Цвет рамки (индикатора) текстового поля, когда оно в фокусе
                                unfocusedIndicatorColor = Color.Transparent, // Цвет рамки (индикатора) текстового поля, когда оно не в фокусе
                                focusedLabelColor = Color.Gray, // Цвет метки (label), когда текстовое поле в фокусе
                                unfocusedLabelColor = Color.Gray, // Цвет метки (label), когда текстовое поле не в фокусе
                                focusedTextColor = Color.Black,//цвет когда вводится текст и он в фокусе
                                unfocusedTextColor = Color.Black//цвет когда вводится текст и он в не в фокусе
                            ),


                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "",
                                    tint = Color.Black,
                                    modifier = Modifier.clickable {
                                        navController.navigate("POISK")
                                    }

                                )
                            },
                            onValueChange = {
                                text = it
                            },
                            label = {
                                Text(
                                    text = "Поиск",
                                    color = Color.Gray
                                )
                            },
                        )
                        IconButton(modifier = Modifier.size(100.dp),
                            onClick = {
                            }) {
                            Image(
                                painter = painterResource(id = R.drawable.group_1000000743),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(end = 10.dp)
                            )
                        }
                    }
                }
                item {
                    Column {
                        Text(
                            text = "Категории",
                            fontSize = 17.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(8.dp)
                        )
                        LazyRow(
                            contentPadding = PaddingValues(//Параметр contentPadding задает отступы вокруг содержимого LazyRow.
                                horizontal = 6.dp,//между краями элемента и установленным контентом будет по 16dp
                                vertical = 8.dp
                            ),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),

                            ) {
                            items(categoryList.size) { index ->
                                ListRow(
                                    model = categoryList[index],
                                    navController = navController  // Передаем navController
                                )
                            }
                        }
                    }
                }
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Популярное",
                            fontSize = 17.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(8.dp)
                        )
                        Box(
                            modifier = Modifier
                                .clickable {
                                    navController.navigate("POPULAR")
                                }
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Все",
                                fontSize = 17.sp,
                                color = Color(0xFF03A9F4)
                            )
                        }

                    }
                }
                item {
                    LazyRow(
                        contentPadding = PaddingValues(//Параметр contentPadding задает отступы вокруг содержимого LazyRow.
                            horizontal = 6.dp,//между краями элемента и установленным контентом будет по 16dp
                            vertical = 8.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),

                        ) {
                        items(categoryListElements.size) { index ->
                            ListRowCat(model = categoryListElements[index],navController = navController )
                        }
                    }
                }
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Акции",
                            fontSize = 17.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(8.dp)
                        )

                        Box(
                            modifier = Modifier
                                .clickable {

                                }
                                .padding(8.dp)
                        ) {
                            Text(
                                text = "Все",
                                fontSize = 17.sp,
                                color = Color(0xFF03A9F4)
                            )
                        }
                    }
                }
                item {
                    Column(  // Добавляем Column для возможности выравнивания
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center// Центрируем содержимое по горизонтали
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.frame_1000000849),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(300.dp)
                                    .padding(start = 8.dp)
                            )
                        }


                    }
                }
            }
            BottomNavigationBarWithBackground(navController)
        }
    }
}

@Composable
fun BoxScope.BottomNavigationBarWithBackground(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .align(Alignment.BottomCenter)
            .navigationBarsPadding()
    ) {
        // Фоновое изображение
        Image(
            painter = painterResource(id = R.drawable.navigationbar),
            contentDescription = "Navigation background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // Получаем текущий маршрут
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        // Навигационные элементы
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationItem(
                icon = R.drawable.home_2,
                contentDescription = "Home",
                isSelected = currentRoute == "home",
                onClick = { navController.navigate("HOME") }
            )
            NavigationItem(
                icon = R.drawable.path,
                contentDescription = "Favorites",
                isSelected = currentRoute == "favorites",
                onClick = { navController.navigate("FAVORITE") }
            )
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)
                    .background(
                        Color(android.graphics.Color.parseColor("#03A9F4")),
                        shape = CircleShape
                    )

            ) {
                NavigationItem(
                    icon = R.drawable.bag2,
                    contentDescription = "Cart",
                    isSelected = currentRoute == "cart",
                    onClick = { navController.navigate("BASKET") }
                )
            }
            NavigationItem(
                icon = R.drawable.vector,
                contentDescription = "Notifications",
                isSelected = currentRoute == "notifications",
                onClick = { navController.navigate("NOTIFICATIONS") }
            )
            NavigationItem(
                icon = R.drawable.frame,
                contentDescription = "Profile",
                isSelected = currentRoute == "profile",
                onClick = { navController.navigate("PROFILE") }
            )
        }
    }
}

@Composable
fun NavigationItem(
    icon: Int,
    contentDescription: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .then(
                if (isSelected) {
                    Modifier
                        .background(
                            color = Color(0xFF40BFFF),
                            shape = CircleShape
                        )
                        .shadow(
                            elevation = 8.dp,
                            shape = CircleShape,
                        )
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(48.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(24.dp),
                colorFilter = if (isSelected) {
                    ColorFilter.tint(Color.White)
                } else {
                    ColorFilter.tint(Color(0xFF9098B1))
                }
            )
        }
    }
}

@Composable
fun ListRow(
    model: CategoryList,
    modifier: Modifier = Modifier,
navController: NavController
    ) {
    Row(//Горизонтальный контейнер для элементов
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(5.dp)
                .clickable {
                    navController.navigate("CATEGORY")
                }
        ) {
            Text(//Отображает название
                text = model.name,
                modifier = Modifier.padding(8.dp),
                fontSize = 18.sp,
                color = Color.Black
            )

        }


    }

}

@Composable
fun ListRowCat(
    model: CategoryElements,
    modifier: Modifier = Modifier,
    navController: NavController

) {
    var isFavorite by remember { mutableStateOf(false) }
    Row(//Горизонтальный контейнер для элементов
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(5.dp)
                .width(170.dp)
                .clickable {
                    // Переход в класс FAVORITE при нажатии на карточку
                    navController.navigate("ABOUT")
                },
            shape = RoundedCornerShape(15.dp), // Устанавливаем ширину карточки в 200dp
        ) {
            IconButton(
                onClick = {
                    isFavorite = !isFavorite  // Меняем состояние при клике
                    if (isFavorite) {
                        navController.navigate("FAVORITE")
                    }
                }
            ) {
                Image(
                    painter = painterResource(
                        id = if (isFavorite) {
                            R.drawable.favor  // Заполненное сердце
                        } else {
                            R.drawable.path  // Пустое сердце
                        }
                    ),
                    contentDescription = "favorite",
                    modifier = Modifier.size(15.dp),
                )
            }
            Image(
                painter = painterResource(id = model.Image),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .padding(start = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(//Отображает название
                text = model.title,
                modifier = Modifier.padding(5.dp),
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = model.name,
                modifier = Modifier.padding(5.dp),
                fontSize = 18.sp,
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = model.prise,
                    modifier = Modifier.padding(5.dp),
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Box(
                    modifier = Modifier
                        .size(40.dp) // Размер контейнера
                        .background(
                            Color(android.graphics.Color.parseColor("#03A9F4")),
                            shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
                        ) // Круглый фон
                        .padding(8.dp), // Отступы внутри
                    contentAlignment = Alignment.Center // Центрируем содержимое
                ) {
                    IconButton(onClick = { /* Действие при нажатии */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.vectorbag),
                            contentDescription = "",
                            modifier = Modifier.size(14.dp),

                            )
                    }
                }

            }
        }


    }

}

@Composable
fun ListRowActia() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .padding(5.dp)
            .width(170.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(  // Добавляем Column для возможности выравнивания
            horizontalAlignment = Alignment.CenterHorizontally  // Центрируем содержимое по горизонтали
        ) {
            Image(
                painter = painterResource(id = R.drawable.frame_1000000849),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun NavigationBar(navController: NavController) {
    var index by remember { mutableStateOf(0) }
    androidx.compose.material3.NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            icon = {
                IconButton(onClick = { /* Действие при нажатии */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.home_2),
                        contentDescription = "home",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            label = {
                Text(
                    text = ""
                )
            },
            selected = index == 0,
            onClick = { index == 0 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.5f),
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White.copy(alpha = 0.5f),
                indicatorColor = Color(android.graphics.Color.parseColor("#D9D9D9"))
            )
        )
        NavigationBarItem(
            icon = {
                IconButton(onClick = { /* Действие при нажатии */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.path),
                        contentDescription = "home",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            label = {
                Text(
                    text = ""
                )
            },
            selected = index == 1,
            onClick = { index == 1 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.5f),
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White.copy(alpha = 0.5f),
                indicatorColor = Color(android.graphics.Color.parseColor("#B4B3B3"))
            )
        )

        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier
                        .size(50.dp) // Размер контейнера
                        .background(
                            Color(android.graphics.Color.parseColor("#03A9F4")),
                            shape = CircleShape
                        ) // Круглый фон
                        .padding(8.dp), // Отступы внутри
                    contentAlignment = Alignment.Center // Центрируем содержимое
                ) {
                    IconButton(onClick = { /* Действие при нажатии */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.bag2),
                            contentDescription = "home",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            },
            label = {
                Text(
                    text = ""
                )
            },
            selected = index == 1,
            onClick = { /* Обработчик клика */ },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.5f),
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White.copy(alpha = 0.5f),
                indicatorColor = Color.Transparent // Используйте прозрачный цвет, если не нужен индикатор
            )
        )

        NavigationBarItem(
            icon = {
                IconButton(onClick = { /* Действие при нажатии */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.vector),
                        contentDescription = "home",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            label = {
                Text(
                    text = ""
                )
            },
            selected = index == 1,
            onClick = { index == 1 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.5f),
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White.copy(alpha = 0.5f),
                indicatorColor = Color(android.graphics.Color.parseColor("#B4B3B3"))
            )
        )
        NavigationBarItem(
            icon = {
                IconButton(onClick = { /* Действие при нажатии */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.frame),
                        contentDescription = "home",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            label = {
                Text(
                    text = ""
                )
            },
            selected = index == 1,
            onClick = { index == 1 },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White.copy(alpha = 0.5f),
                selectedTextColor = Color.White,
                unselectedTextColor = Color.White.copy(alpha = 0.5f),
                indicatorColor = Color(android.graphics.Color.parseColor("#B4B3B3"))
            )
        )
    }
}
@Preview (showBackground = true)
@Composable
fun HomePreview(){
    ProbaProffTheme{
        val navController = rememberNavController()
        Home(navController = navController)
    }
}
