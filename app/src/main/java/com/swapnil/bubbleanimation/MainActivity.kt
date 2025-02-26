package com.swapnil.bubbleanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.swapnil.bubbleanimation.ui.theme.BubbleAnimationTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BubbleAnimationTheme {
                val pagerState = rememberPagerState()

                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                    darkIcons = pagerState.currentPage == 2
                )

                Surface(modifier = Modifier.fillMaxSize()) {
                    BubblePagerContent(pagerState = pagerState)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BubblePagerContent(pagerState: PagerState) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        BubblePager(
            pagerState = pagerState,
            pageCount = onboardingItems.size,
            modifier = Modifier.fillMaxSize(),
            bubbleColors = onboardingItems.map { it.backgroundColor }
        ) { page ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               /* Spacer(modifier = Modifier.height(120.dp))
                Image(
                    modifier = Modifier.size(250.dp),
                    painter = painterResource(id = pages[page].content.imageId),
                    contentDescription = "Image"
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = pages[page].content.text,
                    style = MaterialTheme.typography.headlineMedium,
                    color = if (page == 2) Color.Black else Color.White,
                    textAlign = TextAlign.Center,
                    softWrap = true,
                    modifier = Modifier.padding(horizontal = 40.dp)
                )*/
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(onboardingItems[page].animation))

                // Use animateLottieCompositionAsState inside the Composable scope
                val progress by animateLottieCompositionAsState(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    speed = if(page!=2) 1.8f else 1.0f
                )

                LottieAnimation(
                    composition = composition,
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 140.dp)
                        .height(280.dp)
                )
            }
        }
        PagerTopAppBar(
            page = pagerState.currentPage,
            modifier = Modifier
                .wrapContentSize()
                .statusBarsPadding()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagerTopAppBar(page: Int, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Left Icon",
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu icon",
                )
            }
        },
        colors = TopAppBarColors(
            containerColor = if (page == 2) Color.Black else Color.White,
            scrolledContainerColor = if (page == 2) Color.Black else Color.White,
            actionIconContentColor = if (page == 2) Color.Black else Color.White,
            titleContentColor = if (page == 2) Color.Black else Color.White,
            navigationIconContentColor = if (page == 2) Color.Black else Color.White
        ),
        modifier = modifier
    )
}