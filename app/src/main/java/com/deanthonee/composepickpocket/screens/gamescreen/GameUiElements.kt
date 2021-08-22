package com.deanthonee.composepickpocket.screens.gamescreen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
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
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.deanthonee.composepickpocket.utils.FakeData

class GameUiElements {

    @Composable
    fun ScrollToTopButton(onClick: () -> Unit) =
        Button(
            onClick = { onClick.invoke() },
            modifier = Modifier.padding(bottom = 30.dp),
            shape = CircleShape
        ) {
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
    fun GuessList(list: List<String>, state: LazyListState = rememberLazyListState()) = LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = state,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // change this to handle guess list.
        // this stuff should be moved to the ViewModel
        val sortedList = list.sortedBy { it }
        val groupedNames = sortedList.groupBy { it[0] }

        groupedNames.forEach { initial, names ->
            stickyHeader {
                Text(
                    text = initial.toString(),
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 25.sp
                )
            }
            items(names.size) { index ->
                PhotographerCard(authorName = names[index], index = index)
            }
        }

    }

    @Composable
    fun PhotographerCard(authorName: String, index: Int) {
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
                val randomPicUrl = "https://source.unsplash.com/random/200x200?sig="
                val newUrl = randomPicUrl + (index + 1).toString()
                Image(
                    painter = rememberImagePainter(
                        data = newUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                            crossfade(1000)
                        }),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
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
    fun MyButton(number: String, onClick: () -> Unit) {
        Button(onClick = { onClick.invoke() }) {
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
    fun ButtonRow(){
        Column() {
            Row() {
                MyButton(number = "1") {}
                MyButton(number = "2") {}
                MyButton(number = "3") {}
            }
            Row() {
                MyButton(number = "4") {}
                MyButton(number = "5") {}
                MyButton(number = "6") {}
            }
        }
    }
}

@Preview
@Composable
fun ButtonRowPreview(){
    val ui = GameUiElements()
    ui.ButtonRow()
}

@Preview()
@Composable
fun TopBarPreview() {
    GameUiElements().MyTopBar {}
}

@Preview()
@Composable
fun CardPreviewFromGameUi() {
    GameUiElements().PhotographerCard("DeAnthonee King", 1)
}

@Preview()
@Composable
fun ScrollToTopButtonPreview() {
    val ui = GameUiElements()
    ui.ScrollToTopButton {}
}

@Preview()
@Composable
fun MyButtonPreview() {
    val ui = GameUiElements()
    ui.MyButton(number = "1") {}
}


@ExperimentalFoundationApi
@Preview()
@Composable
fun ListOfNamesPreview() {
    val list = FakeData().listOfFullNames(40)
    val ui = GameUiElements()
    ui.GuessList(list = list)
}


