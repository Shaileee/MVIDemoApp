package com.shaileedemo.mvimovies.uicomponent.search

import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.shaileedemo.mvimovies.R
import com.shaileedemo.mvimovies.uicomponent.theme.MoviesTheme

@Composable
fun TopSearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    searchIconContentDescription: String? = null,
    onSearchEvent: (KeyboardActionScope.() -> Unit)? = null
) {
    TextField(
        value = searchText,
        modifier = modifier,
        onValueChange = onSearchChange,
        placeholder = if (placeholder.isNotEmpty()) {
            { Text(placeholder) }
        } else null,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = searchIconContentDescription
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = onSearchEvent
        )
    )
}

@Preview("TopSearchTextField Light")
@Composable
fun PreviewTopSearchTextFieldLight() {
    MoviesTheme {
        Surface {
            TopSearchTextField(
                searchText = "",
                onSearchChange = {},
                placeholder = "${stringResource(id = R.string.type_a_name)}...",
            )
        }
    }
}

@Preview("TopSearchTextField Dark")
@Composable
fun PreviewTopSearchTextFieldDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            TopSearchTextField(
                searchText = "",
                onSearchChange = {},
                placeholder = "${stringResource(id = R.string.type_a_name)}...",
            )
        }
    }
}