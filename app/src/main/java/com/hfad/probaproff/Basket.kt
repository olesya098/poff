package com.hfad.probaproff

import android.media.midi.MidiDevice
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hfad.probaproff.ui.theme.ProbaProffTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Basket(navController: NavController) {
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
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        bottomBar = { },
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
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color(android.graphics.Color.parseColor("#EFEFEF")))
                .fillMaxSize()
        ) {
            // Обертка для LazyVerticalGrid с отступом снизу
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 200.dp) // Отступ для BasketBar
            ) {
                SwipeableCard(categoryListElements = categoryListElements)
            }

            // BasketBar всегда внизу
            BasketBar(navController)
        }
    }
}

@Composable
fun SwipeableCard(categoryListElements: List<CategoryElements>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), // Один столбец для отображения карточек в виде списка
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(categoryListElements) { item ->
            val offsetX = remember { mutableStateOf(0f) }
            val animatedOffsetX by animateFloatAsState(
                targetValue = offsetX.value,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            val coroutineScope = rememberCoroutineScope()

            // Передаем данные одного элемента
            SwipeableCardContent(
                animatedOffsetX = animatedOffsetX,
                offsetX = offsetX,
                coroutineScope = coroutineScope,
                item = item
            )
        }
    }
}

@Composable
fun SwipeableCardContent(
    animatedOffsetX: Float,
    offsetX: MutableState<Float>,
    coroutineScope: CoroutineScope,
    item: CategoryElements
) {
    // Вычисляем прозрачность красной карточки (слева)
    val blueCardAlpha = remember(animatedOffsetX) {
        // Показываем при свайпе вправо (положительное смещение)
        (animatedOffsetX / 140f).coerceIn(0f, 1f)
    }

    // Вычисляем прозрачность синей карточки (справа)
    val redCardAlpha = remember(animatedOffsetX) {
        // Показываем при свайпе влево (отрицательное смещение)
        ((-animatedOffsetX) / 140f).coerceIn(0f, 1f)
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        // Красная карточка (слева)
        Card(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .height(120.dp)
                .width(60.dp)
                .alpha(redCardAlpha),
            colors = CardDefaults.cardColors(
                containerColor = Color(android.graphics.Color.parseColor("#F87265"))
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        // Синяя карточка
        Card(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .height(120.dp)
                .width(60.dp)
                .alpha(blueCardAlpha),
            colors = CardDefaults.cardColors(
                containerColor = Color(android.graphics.Color.parseColor("#48ABE7"))
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = 32.sp
                    )
                    Text(
                        text = "1",
                        color = Color.White,
                        fontSize = 32.sp
                    )
                    Text(
                        text = "-",
                        color = Color.White,
                        fontSize = 32.sp
                    )
                }
            }
        }

        // Основная карточка с контентом
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .offset { IntOffset(animatedOffsetX.roundToInt(), 0) }
                .padding(12.dp)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            coroutineScope.launch {
                                // Возвращаем карточку на место
                                offsetX.value = 0f
                            }
                        },
                        onHorizontalDrag = { change, dragAmount ->
                            change.consume()
                            // Увеличили диапазон свайпа в обе стороны
                            val newOffset = (offsetX.value + dragAmount).coerceIn(-140f, 140f)
                            offsetX.value = newOffset
                        }
                    )
                },
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(90.dp)
                        .width(87.dp)
                        .background(
                            Color(0xFFF7F7F9),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = item.Image),
                        contentDescription = null,
                        modifier = Modifier
                            .height(90.dp)
                            .width(87.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Column {
                    Text(
                        text = item.name,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 16.sp
                    )
                    Text(
                        text = item.prise,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BasketBar( navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize() // Заполняет весь доступный размер
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .align(Alignment.BottomCenter) // Выравнивает Column по низу
                .fillMaxWidth() // Растягивает на всю ширину
                .padding(start = 12.dp,
                    end = 12.dp,
                    bottom = 12.dp,
                    top = 22.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
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
                text = "------------------------------------------",
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
                onClick = { navController.navigate("BASKETZACAZ") },
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
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BasketPreview() {
    ProbaProffTheme {
        val navController = rememberNavController()
        Basket(navController = navController)
    }
}
