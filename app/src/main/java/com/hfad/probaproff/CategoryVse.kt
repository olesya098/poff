package com.hfad.probaproff

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryVse(navController: NavController) {
    val categoryListElementss = remember {
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
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
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
                            text = "Популярное",
                            fontSize = 17.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(40.dp)
                                .background(
                                    Color.White,
                                    shape = CircleShape
                                )

                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "",
                                    tint = Color.Black
                                )
                            }
                        }

                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        )
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            )

            {
                items(categoryListElementss) { card ->
                    CardPop(c = card, navController)
                }
                item(
                    span = {
                        GridItemSpan(2)
                    }
                ) {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryVsePreview() {
    ProbaProffTheme {
        val navController =
            rememberNavController()//Эта функция создает экземпляр NavController, который можно использовать в вашем приложении.
        CategoryVse(navController = navController)
    }
}
