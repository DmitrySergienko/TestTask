package com.example.testtask.ui.screens.cameras

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtask.R
import com.example.testtask.domain.Camera
import com.example.testtask.ui.presentation.GlideImage

@Composable
fun CamerasItem(cameras: Camera) {

    Log.d("VVV", "CamerasItem() called with: cameras = $cameras")

    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            GlideImage(
                url = cameras.snapshot,
                contentDescription = cameras.name,

            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = cameras.name,
                style = TextStyle(
                    fontSize = 21.sp,
                    fontFamily = FontFamily(Font(R.font.crc55)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF333333),
                )
            )
        }
    }
}









