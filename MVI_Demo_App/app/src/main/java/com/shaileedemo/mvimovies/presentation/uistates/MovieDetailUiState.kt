package com.shaileedemo.mvimovies.presentation.uistates

import com.shaileedemo.mvimovies.uicomponent.template.AttrsDetailTemplate

sealed interface MovieDetailUiState {
    data object Loading : MovieDetailUiState
    data class Display(val attributes: AttrsDetailTemplate) : MovieDetailUiState
    data object Error : MovieDetailUiState
}
