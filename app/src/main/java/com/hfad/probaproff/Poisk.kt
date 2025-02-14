package com.hfad.probaproff

import android.provider.ContactsContract.CommonDataKinds.Im
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.Gray2
import com.hfad.probaproff.ui.theme.ProbaProffTheme
data class Objekt(
    var name: String
){}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Poisk(navController: NavController) {
    var text1 by remember { mutableStateOf("Поиск") }
    var list = remember { mutableStateListOf(
        Objekt(
            "New Shoes"
        ),
        Objekt(
            "Nike Top Shoes"
        ),
        Objekt(
            "Nike Air Force"
        ),
        Objekt(
            "Shoes"
        ),
        Objekt(
            "Snakers Nike Shoes"
        ),
        Objekt(
            "Regular Shoes"
        ),
    ) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =Color(android.graphics.Color.parseColor("#EFEFEF"))

            ),
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(40.dp)
                                .background(color = Color.White, shape = CircleShape)
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.clickable {
                                        navController.navigate("HOME")
                                    }
                                )
                            }

                        }

                        Text(
                            text = "Поиск",
                            color = Color.Black,
                            modifier = Modifier.padding(start = 90.dp)

                        )

                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues).background(Color(android.graphics.Color.parseColor("#EFEFEF")))

        ){
            Column (modifier = Modifier.fillMaxSize()
                .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(). padding(14.dp)
                ) {
                    TextField(
                        value = text1,
                        onValueChange = {
                            text1 = it
                        },
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
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        },
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null,
                                modifier = Modifier.size(25.dp)
                            )
                        }


                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn {
                    items(list.size) { index ->
                        card(list = list[index])
                    }
                }

            }

        }

    }
}
@Composable
fun card(list: Objekt) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.time),
            contentDescription = null,
            modifier = Modifier.size(40.dp). padding(8.dp)
        )
        Text(
            text = list.name,
            modifier = Modifier. padding(8.dp),
            color = Color.Black
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PoiskPreview() {
    ProbaProffTheme {
        val navController = rememberNavController()
        Poisk(navController = navController)
    }

}