package com.shaileedemo.mvimovies.uicomponent.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shaileedemo.mvimovies.uicomponent.theme.MoviesTheme

@Composable
fun Subtitle1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
    )
}

@Preview("Subtitle1 Light")
@Composable
fun PreviewSubtitle1Light() {
    MoviesTheme {
        Surface {
            Subtitle2("Subtitle1")
        }
    }
}

@Preview("Subtitle1 Dark")
@Composable
fun PreviewSubtitle1Dark() {
    MoviesTheme(darkTheme = true) {
        Surface {
            Subtitle2("Subtitle1")
        }
    }
}