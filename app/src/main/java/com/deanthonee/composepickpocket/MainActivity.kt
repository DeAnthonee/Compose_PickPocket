package com.deanthonee.composepickpocket

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deanthonee.composepickpocket.ui.theme.ComposePickPocketTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePickPocketTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyButton(number = "Here is a button")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposePickPocketTheme {
        PhotographerCard()
    }
}

@Composable
fun PhotographerCard() {
    val context = LocalContext.current
    Row(modifier = Modifier
        .padding(24.dp)
        .clickable { Toast.makeText(context, "Heard", Toast.LENGTH_SHORT).show() }
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column(modifier = Modifier.padding(start = 100.dp)) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
fun MyButton(number: String) {
    // TODO Center text
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