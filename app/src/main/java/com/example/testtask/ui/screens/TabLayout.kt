package com.example.testtask.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtask.R
import com.example.testtask.ui.presentation.MainViewModel
import com.example.testtask.ui.screens.cameras.DoorRecyclerScreen
import com.example.testtask.ui.screens.cameras.RecyclerScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
    viewModel: MainViewModel
) {
    val tabList = listOf(
        stringResource(id = R.string.cameras),
        stringResource(id = R.string.doors),

    )

    val pageState = rememberPagerState()
    val tabIndex = pageState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 2.dp, end = 2.dp)
            .clip(RoundedCornerShape(1.dp))

    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(pageState, pos)
                )
            },
            modifier = Modifier.alpha(0.94f),
            backgroundColor = Color.Transparent,
            contentColor = Color.Black,

        ) {

            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pageState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = text,
                            style = TextStyle(
                                fontSize = 17.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.crc55)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF333333),
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pageState,
            modifier = Modifier
                .weight(1.0f)
        ) { tabIndex ->
            when (tabIndex) {
                0 -> RecyclerScreen(viewModel = viewModel)
                1 -> DoorRecyclerScreen(viewModel = viewModel)
            }
        }
    }
}