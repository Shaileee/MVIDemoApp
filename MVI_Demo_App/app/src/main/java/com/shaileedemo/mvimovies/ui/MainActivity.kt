package com.shaileedemo.mvimovies.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.Surface
import com.shaileedemo.mvimovies.presentation.navigation.NavGraph
import com.shaileedemo.mvimovies.uicomponent.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Surface {
                    NavGraph()
                }
            }
        }
    }
}
