package com.nghtamm.pokedextionary.features.onboarding.presentation

import androidx.activity.compose.LocalActivity
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.nghtamm.pokedextionary.R
import com.nghtamm.pokedextionary.core.navigation.Screen
import com.nghtamm.pokedextionary.core.theme.*
import com.nghtamm.pokedextionary.features.onboarding.data.local.pagesData
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingScreen(
    navController: NavHostController
) {
    val window = (LocalActivity.current)?.window
    SideEffect {
        window?.let {
            @Suppress("DEPRECATION")
            it.statusBarColor = Primary.toArgb()
            @Suppress("DEPRECATION")
            it.navigationBarColor = Primary.toArgb()

            WindowCompat.getInsetsController(it, it.decorView)
                .isAppearanceLightStatusBars = true
        }
    }

    val pagerState = rememberPagerState(
        pageCount = { pagesData.size }
    )
    val coroutineScope = rememberCoroutineScope()
    val onboardingViewModel: OnboardingViewModel = koinViewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pokeball),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.TopEnd)
                .offset(x = 50.dp, y = (-50).dp)
                .alpha(0.1f)
        )
        Column {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                val pagesData = pagesData[page]
                OnboardingPage(
                    image = pagesData.image,
                    title = pagesData.title,
                    content = pagesData.content
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            ) {
                PagerIndicator(
                    size = pagesData.size,
                    current = pagerState.currentPage
                )
                Button(
                    onClick = {
                        if (pagerState.currentPage < pagesData.size - 1) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            onboardingViewModel.complete()
                            navController.navigate(Screen.Pokedex.route) {
                                popUpTo(Screen.Onboarding.route) {
                                    inclusive = true
                                }
                            }
                        }
                    },
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = DarkPrimary,
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .width(120.dp)
                ) {
                    Text(
                        text = if (pagerState.currentPage < pagesData.size - 1)
                            "Next" + "\t " + "→"
                        else
                            "Start",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = LightPrimary
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun PagerIndicator(
    size: Int,
    current: Int
) {
    Row {
        repeat(size) {
            val isSelected = it == current
            val width = animateDpAsState(
                targetValue = if (isSelected)
                    30.dp
                else
                    10.dp
            )

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .height(10.dp)
                    .width(width.value)
                    .clip(CircleShape)
                    .background(
                        if (isSelected)
                            DarkPrimary
                        else
                            DarkPrimary.copy(alpha = 0.5f)
                    )
            )
        }
    }
}

@Composable
fun OnboardingPage(
    image: Int? = null,
    title: String,
    content: String? = null
) {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (image != null) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.size(width = 240.dp, height = 240.dp)
                )
                Spacer(
                    modifier = Modifier.height(40.dp)
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = DarkPrimary
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )
            if (content != null) {
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = DarkPrimary
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 30.dp)
                )
            }
        }
    }
}
