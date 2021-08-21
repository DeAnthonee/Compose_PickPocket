package com.deanthonee.composepickpocket.screens.home

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deanthonee.composepickpocket.screens.gamescreen.GameUiElements
import com.deanthonee.composepickpocket.ui.theme.ComposePickPocketTheme
import java.util.ArrayList

@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    private val randomPicUrl = "https://source.unsplash.com/random/200x200?sig="
    private lateinit var names: List<String>
    private lateinit var context: Context
    val ui = GameUiElements()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePickPocketTheme {
                context = LocalContext.current
                names = listOfPhotographers(300)
                RootLayout(list = names, ui = ui)

            }
        }
    }

}

private fun littleAction(context: Context) {
    Toast.makeText(context, "Heard", Toast.LENGTH_SHORT).show()
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun RootLayout(modifier: Modifier = Modifier, list: List<String>, ui: GameUiElements) {
    val context = LocalContext.current
    val listState = rememberLazyListState()

    // Should try to extract this out as well
    Scaffold(
        modifier = modifier,
        topBar = {
            ui.MyTopBar {
                littleAction(context = context)
            }
        }
    ) {
        Box() {
            ui.GuessList(list = list, state = listState)
        }
    }

    val showButton = listState.firstVisibleItemIndex > 5

    AnimatedVisibility(
        visible = showButton,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        ui.ScrollToTopButton {
            littleAction(context = context)
        }
    }

}

@ExperimentalAnimationApi
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun RootLayoutPreview() {
    val ui = GameUiElements()
    ComposePickPocketTheme {
        RootLayout(Modifier.padding(5.dp), list = listOfPhotographers(50), ui = ui)
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposePickPocketTheme {
        PhotographerCard("DeAnthonee King")
    }
}

fun listOfPhotographers(numberOfNames: Int): List<String> {

    val listOfFirstNames = listOf(
        "Maggie",
        "Johhny",
        "Orin",
        "Tiffany",
        "Sabrina",
        "Erin",
        "Alberto",
        "Andy",
        "Anthony",
        "DeAnthonee",
        "Dejean",
        "Demonte",
        "DeMario",
        "Kennedy-Anne",
        "Bobby",
        "Billy",
        "Corey",
        "Zappy",
        "Xina",
        "Xeolyne",
        "Stacy"
    )
    val listOfLastNames = listOf(
        "Johnson",
        "Stevens",
        "Tillsons",
        "Smiths",
        "Legend",
        "Marvel",
        "Torando",
        "Sharker",
        "Nagger",
        "Neegan",
        "Milly Wap"
    )

    val fullNames = ArrayList<String>()

    for (x in 0..numberOfNames) {
        val first = listOfFirstNames.random()
        val last = listOfLastNames.random()
        val name = "$first $last"
        fullNames.add(name)
    }
    return fullNames
}

@Composable
fun PhotographerCard(authorName: String) {
    val context = LocalContext.current
    Row(modifier = Modifier
        .clickable {
            Toast
                .makeText(context, "Heard", Toast.LENGTH_SHORT)
                .show()
        }
        .clip(RoundedCornerShape(40.dp))
        .background(Color.Gray)
        .padding(end = 10.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here

        }
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(authorName, fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun MyButton(number: String) {
    val context = LocalContext.current
    Button(onClick = { Toast.makeText(context, "Heard", Toast.LENGTH_SHORT).show() }) {
        Box(
            Modifier
                .height(100.dp)
                .width(100.dp)
                .background(Color.Cyan),

            ) {
            Text(
                text = number,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        Modifier
            .background(Color.Blue)
            .padding(30.dp)
    ) {
        Text(text = "Hello $name!", fontSize = 24.sp)
    }

}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    ComposePickPocketTheme() {
        MyButton(number = "1")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePickPocketTheme {
        Greeting("Android")
    }
}