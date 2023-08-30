package com.example.testtask.ui.screens.cameras

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtask.R
import com.example.testtask.domain.Camera
import com.example.testtask.ui.presentation.GlideImage
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox


@Composable
fun CamerasItem(cameras: Camera) {

    val context = LocalContext.current

    //===========swipe========
    val archive = SwipeAction(
        onSwipe = {},
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.baseline_mode_edit_24),
                contentDescription = null,
            )
        },
        background = Color.Transparent
    )
    val update = SwipeAction(
        onSwipe = { Toast.makeText(context, "!!!", Toast.LENGTH_SHORT).show()},
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.baseline_mode_edit_24),
                contentDescription = null,
            )
        },
        background = Color.Transparent
    )

    //================swipe single item=============

    SwipeableActionsBox(
        modifier = Modifier.background(Color.Transparent),
        swipeThreshold = 50.dp,
        startActions = listOf(archive),
        endActions = listOf(update),
        backgroundUntilSwipeThreshold = Color.Transparent
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, top = 4.dp),
            shape = RoundedCornerShape(16.dp),

            ) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
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
}









