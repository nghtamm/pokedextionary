package com.nghtamm.pokedextionary.shared.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nghtamm.pokedextionary.core.theme.*
import com.nghtamm.pokedextionary.shared.data.navigationItems

@ExperimentalMaterial3Api
@Composable
fun HomeBottomSheet(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    navController: NavHostController,
) {
    ModalBottomSheet(
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        containerColor = LightPrimary,
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .width(60.dp)
                    .height(4.dp)
                    .background(
                        color = DarkPrimary.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(100)
                    )
            )
        },
        onDismissRequest = onDismissRequest,
        sheetState = sheetState
    ) {
        Text(
            text = "What are you looking for?",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(vertical = 8.dp)
                .height(4.dp)
                .background(
                    color = CoralRed,
                    shape = RoundedCornerShape(100)
                )
                .align(Alignment.CenterHorizontally)
        )

        navigationItems.forEachIndexed { index, item ->
            NavigationButton(
                title = item.title,
                color = item.color,
                image = item.image,
                navController = navController,
                route = item.route
            )
            if (index < navigationItems.lastIndex) {
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
            } else if (index == navigationItems.lastIndex) {
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
        }
    }
}

@Composable
fun NavigationButton(
    title: String,
    color: Brush,
    image: Int,
    navController: NavHostController,
    route: String,
) {
    Button(
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(),
        onClick = {
            navController.popBackStack()
            navController.navigate(route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 20.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .scale(2f)
                    .align(Alignment.TopEnd)
                    .offset(x = 12.dp, y = 8.dp)
                    .alpha(0.1f)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}