package com.nghtamm.pokedextionary.shared.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.nghtamm.pokedextionary.core.theme.*

@ExperimentalMaterial3Api
@Composable
fun HomeSearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    interactionSource: MutableInteractionSource
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = DarkPrimary
        ),
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                innerTextField = innerTextField,
                value = value,
                singleLine = true,
                enabled = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = DarkPrimary
                        )
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = DarkPrimary
                    )
                },
                contentPadding = PaddingValues(),
                shape = RoundedCornerShape(32.dp),
                container = {
                    Box(
                        modifier = Modifier
                            .background(
                                color = DarkPrimary.copy(alpha = 0.125f),
                                shape = RoundedCornerShape(32.dp)
                            )
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = DarkPrimary,
                    focusedContainerColor = DarkPrimary.copy(alpha = 0.125f),
                    unfocusedContainerColor = DarkPrimary.copy(alpha = 0.125f),
                    focusedTextColor = DarkPrimary,
                    unfocusedTextColor = DarkPrimary,
                    focusedPlaceholderColor = DarkPrimary,
                    unfocusedPlaceholderColor = DarkPrimary,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent
                )
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 18.dp),
    )
}