package com.dev_ankur.infoappmvvm.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.assignmentpw.R
import kotlinx.coroutines.delay


@Composable
fun BannerScreen(navController: NavHostController) {
    val modifier = Modifier
    Box(modifier = modifier.fillMaxSize()) {

        val scale = remember { mutableStateOf(0f) }
        val animatedScale = animateFloatAsState(targetValue = scale.value)

        LaunchedEffect(Unit) {
            delay(1000)
            scale.value = 1.5f
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.rick_morty_splash),
                contentDescription = stringResource(id = R.string.app_logo),
                modifier = Modifier
                    .size(200.dp)
                    .scale(animatedScale.value),
                contentScale = ContentScale.Fit
            )
        }


        Column(
            modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val linearGradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFede658),
                    Color(0xFFede658),
                    Color(0xFFede658),
                    Color(0xFFede658)
                ),
                start = Offset(Float.POSITIVE_INFINITY, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY),
            )
            Button(
                onClick = { navController.navigate("Home Screen") },
                modifier
                    .padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .background(color = Color.Gray.copy(0.8f), RoundedCornerShape(16.dp))
                    .border(
                        BorderStroke(3.dp, linearGradientBrush),
                        shape = RoundedCornerShape(16.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(text = stringResource(id = R.string.get_in) ,style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.cinzel_decorative)),
                    textAlign = TextAlign.Center
                ))
            }
        }
    }




}