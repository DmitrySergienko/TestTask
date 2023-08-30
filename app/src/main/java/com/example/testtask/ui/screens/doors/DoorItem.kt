package com.example.testtask.ui.screens.cameras

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.testtask.R
import com.example.testtask.domain.Door
import com.example.testtask.ui.presentation.GlideImage
import com.example.testtask.ui.presentation.MainViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun DoorItem(door: Door, viewModel: MainViewModel) {

    val context = LocalContext.current
    var text by remember { mutableStateOf(TextFieldValue(door.name)) }

    Log.d("VVV", "DoorItem() called with: door = $door")


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
        onSwipe = { Toast.makeText(context, "!!!", Toast.LENGTH_SHORT).show() },
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
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = null,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent),
                    keyboardActions = KeyboardActions(onDone = {

                        //1.save data in db
                        viewModel.saveUser(text.text,false)

                        //2.toast
                        Toast.makeText(context, "Saved in bd", Toast.LENGTH_SHORT).show()
                    }),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done)
                )
            }
        }
    }
}









