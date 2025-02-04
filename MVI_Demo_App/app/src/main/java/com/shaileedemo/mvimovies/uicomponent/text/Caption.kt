package com.shaileedemo.mvimovies.uicomponent.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shaileedemo.mvimovies.uicomponent.theme.MoviesTheme

@Composable
fun Caption(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge,
        modifier = modifier
    )
}

@Preview("Caption Light")
@Composable
fun PreviewCaptionLight() {
    MoviesTheme {
        Surface {
            Caption("Caption")
        }
    }
}

@Preview("Caption Dark")
@Composable
fun PreviewCaptionDark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            Caption("Caption")
        }
    }
}