package com.hfad.probaproff

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

data class Slide(
    val image: Int,
    val title1: String,
    val title2: String,
    val title3: String,
    val buttonText: String,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Priv(navController: NavController) {
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(23, 172, 239, 255),
            Color(22, 156, 217, 255),
            Color(15, 123, 173, 255),
            Color(13, 93, 131, 255)
        )
    )

    val slides = listOf(
        Slide(
            image = R.drawable.cross1,
            title1 = "Добро",
            title2 = "пожаловать",
            title3 = "",
            buttonText = "Далее"
        ),
        Slide(
            image = R.drawable.cross2,
            title1 = "Начнем",
            title2 = "путешествие",
            title3 = "Умная, великолепная и модная коллекция Изучите сейчас",
            buttonText = "Далее"
        ),
        Slide(
            image = R.drawable.cross3,
            title1 = "У вас есть сила, ",
            title2 = "чтобы",
            title3 = "В вашей комнате много красивых и привлекательных растений",
            buttonText = "Начать"
        )
    )
    // Состояние для управления страницами слайдера
    val pagerState = rememberPagerState(pageCount = { slides.size })
    // Скоуп для управления корутины
    val scope = rememberCoroutineScope()


    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(gradient)
                .fillMaxSize()
                .padding(top = 70.dp)
        ) {
            // HorizontalPager для реализации горизонтального слайдера
            HorizontalPager(
                state = pagerState, // Подключаем состояние слайдера
                modifier = Modifier.weight(1f) // Занимаем оставшуюся высоту
            ) { page ->
                // Получаем текущий слайд в зависимости от номера страницы
                val slide = slides[page]
                // Внутренний контейнер для каждого слайда
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth() // Занимаем всю ширину
                ) {
                    if (page == 0) { // Если это первый слайд
                        // Отображаем заголовок 1
                        Text(
                            text = slide.title1,
                            fontSize = 32.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 48.dp, bottom = 5.dp)
                        )
                        Text(
                            text = slide.title2,
                            fontSize = 32.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 3.dp)
                        )
                        Text(
                            text = slide.title3,
                            fontSize = 18.sp,
                            color = Color(android.graphics.Color.parseColor("#E9E8E8")),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(8.dp)
                        )
                        Image(
                            painter = painterResource(id = slide.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                                .padding(top = 16.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = slide.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = slide.title1,
                            fontSize = 32.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 48.dp, bottom = 5.dp)
                        )
                        Text(
                            text = slide.title2,
                            fontSize = 32.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 3.dp)
                        )
                        Text(
                            text = slide.title3,
                            fontSize = 18.sp,
                            color = Color(android.graphics.Color.parseColor("#E9E8E8")),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(slides.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration)
                        Color.White
                    else
                        Color.White.copy(alpha = 0.3f)
                    val width = if (pagerState.currentPage == iteration) 49.dp else 29.dp

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(width = width, height = 6.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .padding(bottom = 62.dp)
                    .width(300.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(android.graphics.Color.parseColor("#FDD9B5"))
                ),
                onClick = {
                    // Обработчик клика на кнопку
                    if (pagerState.currentPage < slides.size - 1) { // Проверяем, что текущая страница меньше последней
                        scope.launch { // Запускаем новую сопрограмму в корутине
                            pagerState.scrollToPage(pagerState.currentPage + 1) // Прокручиваем к следующей странице
                        }
                    } else { // Если текущая страница - последняя
                        navController.navigate("LOGIN_SCREEN") // Переходим к экрану логина
                    }
                }
            ) {
                Text(
                    slides[pagerState.currentPage].buttonText,
                    color = Color.Black
                )
            }
        }
    }
}