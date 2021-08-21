package com.deanthonee.composepickpocket.screens.gamescreen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.deanthonee.composepickpocket.ui.theme.ComposePickPocketTheme

@ExperimentalFoundationApi
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            ComposePickPocketTheme() {


            }
        }
    }

}

val ui = GameUiElements()

@Composable
fun setBodyUi(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {ui.MyTopBar()}
    ) {

    }
}

@Composable
fun MyTopBar() {
    return TopAppBar(
        title = { Text(text = "Pick Pocket") },
        actions = {
            IconButton(onClick = {
                iconAction()
            }) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
            }
        }
    )
}

fun iconAction() {

}
