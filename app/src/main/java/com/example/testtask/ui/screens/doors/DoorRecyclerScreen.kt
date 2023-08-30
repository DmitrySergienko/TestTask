package com.example.testtask.ui.screens.cameras

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
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
fun DoorRecyclerScreen(viewModel: MainViewModel) {

    val doors by viewModel.doors.observeAsState(listOf())

    LaunchedEffect(Unit) {
        viewModel.fetchDoors()
        Log.d("VVV", "DoorRecyclerScreen() called")
    }

    LazyColumn(
        contentPadding = PaddingValues(bottom = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF6F6F6))
    ) {

        items(doors) { door ->
            DoorItem(door,viewModel)
        }
    }
}

