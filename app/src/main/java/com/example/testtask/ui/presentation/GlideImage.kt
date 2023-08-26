package com.example.testtask.ui.presentation

import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide

@Composable
fun GlideImage(url: String, contentDescription: String) {
    val context = LocalContext.current
    val glide = Glide.with(context)
    val requestBuilder = glide.asBitmap().load(url)

    AndroidView(
        modifier = Modifier.size(200.dp),
        factory = { context ->
            ImageView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        },
        update = {
            requestBuilder.into(it)
        }
    )
}
