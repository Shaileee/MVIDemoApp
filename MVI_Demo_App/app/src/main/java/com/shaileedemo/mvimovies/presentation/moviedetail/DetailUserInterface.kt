package com.shaileedemo.mvimovies.presentation.moviedetail

import com.shaileedemo.mvimovies.uicomponent.template.AttrsDetailTemplate

data class DetailUserInterface(
    val isLoading: Boolean = false,
    val attributes: AttrsDetailTemplate? = null,
    val errorMessage: String? = null
)
