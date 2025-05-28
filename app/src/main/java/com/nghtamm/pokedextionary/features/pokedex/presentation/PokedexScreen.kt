package com.nghtamm.pokedextionary.features.pokedex.presentation

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.nghtamm.pokedextionary.R
import com.nghtamm.pokedextionary.core.theme.LightPrimary
import com.nghtamm.pokedextionary.core.utils.*
import com.nghtamm.pokedextionary.features.pokedex.data.models.PokemonList
import com.nghtamm.pokedextionary.shared.composable.*
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterial3Api
@Composable
fun PokedexScreen(
    navController: NavHostController
) {
    val window = (LocalActivity.current)?.window
    SideEffect {
        window?.let {
            @Suppress("DEPRECATION")
            it.statusBarColor = LightPrimary.toArgb()
            @Suppress("DEPRECATION")
            it.navigationBarColor = LightPrimary.toArgb()

            WindowCompat.getInsetsController(it, it.decorView)
                .isAppearanceLightStatusBars = true
        }
    }

    val viewModel: PokedexViewModel = koinViewModel()
    LaunchedEffect(Unit) {
        viewModel.getPokemonList()
    }
    val state by viewModel.state.collectAsState()

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    var query by remember {
        mutableStateOf("")
    }

    Scaffold(
        containerColor = LightPrimary,
        topBar = {
            HomeTopAppBar(
                title = "Pokédex",
                onTitleClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { padding ->
        if (showBottomSheet) {
            HomeBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                navController = navController
            )
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                HomeSearchBar(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = "What Pokémon are you looking for?",
                    interactionSource = interactionSource,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
            when (val result = state) {
                is PokedexState.Loading -> {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                is PokedexState.Error -> {
                    item { Text(text = result.message, color = MaterialTheme.colorScheme.error) }
                }

                is PokedexState.Success -> {
                    items(result.data.size) { index ->
                        PokemonCard(pokemon = result.data[index])
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonCard(
    pokemon: PokemonList
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = TypeUtils.getTypeStyle(
                pokemon.types.first()
            ).backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 6.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterEnd)
                    .alpha(0.08f)
                    .offset(x = 10.dp, y = 25.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 18.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = NameUtils.formatPokemonName(pokemon.name),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            color = LightPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )
                    Row {
                        pokemon.types.forEach { type ->
                            Card(
                                shape = RoundedCornerShape(100),
                                colors = CardDefaults.cardColors(
                                    containerColor = TypeUtils.getTypeStyle(type).color
                                ),
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = TypeUtils.getTypeStyle(type).icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Spacer(
                                        modifier = Modifier.width(4.dp)
                                    )
                                    Text(
                                        text = type.replaceFirstChar {
                                            it.uppercase()
                                        },
                                        style = MaterialTheme.typography.labelLarge.copy(
                                            color = LightPrimary
                                        ),
                                    )
                                }
                            }
                            Spacer(
                                modifier = Modifier.width(6.dp)
                            )
                        }
                    }
                    Text(
                        text = NumberUtils.formatPokemonNumber(pokemon.id),
                        style = MaterialTheme.typography.headlineLarge.copy(
                            color = LightPrimary.copy(alpha = 0.6f),
                            fontWeight = FontWeight.Black
                        ),
                    )
                }
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemon.sprite)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 18.dp)
                )
            }
        }
    }
}