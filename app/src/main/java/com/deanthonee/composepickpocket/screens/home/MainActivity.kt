package com.deanthonee.composepickpocket.screens.home

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    private val randomPicUrl = "https://source.unsplash.com/random/200x200?sig="
    private lateinit var names: List<String>
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePickPocketTheme {
                context = LocalContext.current
                names = listOfPhotographers(40)
                RootLayout(list = names)
            }
        }
    }

}

private fun littleAction(context: Context){
    Toast.makeText(context, "Heard", Toast.LENGTH_SHORT).show()
}

@ExperimentalFoundationApi
@Composable
fun RootLayout(modifier: Modifier = Modifier, list: List<String>) {
    val context = LocalContext.current
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Pick Pocket") },
                actions = {
                    IconButton(onClick = {
                        littleAction(context = context)
                    }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) {
        val ui = GameUiElements()
        ui.GuessList(list = list)
        
//        LazyColumn(
//            modifier = modifier
//                .fillMaxWidth(),
//            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            val sortedList = list.sortedBy { it }
//            val groupedNames = sortedList.groupBy { it[0] }
//
//
//            groupedNames.forEach { intial, contacts ->
//                stickyHeader {
//                    Text(text = intial.toString())
//                }
//                contacts.forEach {
//                    item {
//                        PhotographerCard(authorName = it)
//                    }
//                }
//            }
//        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun RootLayoutPreview() {
    ComposePickPocketTheme {
        RootLayout(Modifier.padding(5.dp), list = listOfPhotographers(50))
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