package com.example.characterapp.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.example.characterapp.Constants.AppConstants

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Text(text = AppConstants.APP_NAME)
        }
    )
}