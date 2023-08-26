package com.example.testtask.ui.screens.cameras

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.testtask.domain.Door
import com.example.testtask.ui.presentation.GlideImage

@Composable
fun DoorItem(door: Door) {

    Log.d("VVV", "DoorItem() called with: door = $door")

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 4.dp, top = 4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            door.snapshot?.let {
                GlideImage(
                    url = it,
                    contentDescription = door.name,

                    )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = door.name,
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









