package com.example.testtask.ui.screens.cameras

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testtask.ui.presentation.MainViewModel


@Composable
fun RecyclerScreen(viewModel: MainViewModel) {

    val cameras by viewModel.cameras.observeAsState(listOf())

    LaunchedEffect(Unit) {
        viewModel.fetchCameras()
    }

    LazyColumn(
        contentPadding = PaddingValues(bottom = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)
            .background(color = Color(0xFFF6F6F6))
    ) {

        items(cameras) { camera ->
            CamerasItem(camera)
        }
    }
}

