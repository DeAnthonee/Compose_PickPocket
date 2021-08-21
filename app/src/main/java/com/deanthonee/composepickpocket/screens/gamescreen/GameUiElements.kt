package com.deanthonee.composepickpocket.screens.gamescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.deanthonee.composepickpocket.screens.home.PhotographerCard

class GameUiElements {
    
    @Composable
    fun ScrollToTopButton(onClick: () -> Unit) = Button(onClick = { onClick.invoke() }) {
        Text(text = "Scroll To Top")
    }

    @Composable
    fun MyTopBar(onClick: () -> Unit) = TopAppBar(
        title = { Text(text = "Pick Pocket") },
        actions = {
            IconButton(onClick = {
                onClick.invoke()
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        }
    )

    @ExperimentalFoundationApi
    @Composable
    fun GuessList(list: List<String>, state:LazyListState = rememberLazyListState()) = LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = state,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // change this to handle guess list.
        val sortedList = list.sortedBy { it }
        val groupedNames = sortedList.groupBy { it[0] }
        groupedNames.forEach { initial, names ->
            stickyHeader {
                Text(text = initial.toString())
            }
            items(names.size) { index ->
                PhotographerCard(authorName = names[index])
            }
        }

    }
}

