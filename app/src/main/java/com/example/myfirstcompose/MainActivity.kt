package com.example.myfirstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.ui.theme.MyFirstcomposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstcomposeTheme {
                Surface(color = MaterialTheme.colorScheme.background) { // FIXED LINE
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(value = false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(20.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp)

        ) {

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally)
            {
                CreateImageProfile()
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.LightGray
                )
                CreateUserInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary, contentColor = Color.White ) ) {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.labelMedium )

                }
                if (buttonClickedState.value){
                    Content()
                }
                else{
                    Box(){

                    }
                }
            }



            }
    }
}
@Composable
fun CreateUserInfo(modifier: Modifier = Modifier
    )
{
    Column(modifier = Modifier.padding(5.dp)) {
            Text(
                text = "Diddy P.",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "Android Compose Programmer",
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "@ThediddlerSmith",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }

@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)
    ){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1",
                                    "Project 2",
                                    "Project 3",
                                    "Project 4" ))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
    items(data) {item ->
        Card(modifier = Modifier
            .padding(13.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation( 4.dp)

        )
        {
            Row(modifier = Modifier
                .padding(7.dp)

            )
            {
                CreateImageProfile(modifier = Modifier
                    .size(100.dp))
                Column(modifier = Modifier.padding(7.dp)
                    .align(alignment = Alignment.CenterVertically)) {
                    Text(
                        item, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "A great didler project", style = MaterialTheme.typography.bodyMedium
                    )
                }

            }
        }

    }
    }
}

@Composable
 fun CreateImageProfile(modifier: Modifier = Modifier)
    {
        Surface(
            modifier = modifier
                .size(150.dp) // Fixed size for the circle
                .padding(4.dp), // Padding around the surface
            shape = CircleShape, // Circular shape
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f), // Light background
            border = BorderStroke(1.dp, Color.LightGray), // Light gray border
            shadowElevation = 4.dp // Elevation for depth
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
                contentDescription = "profile pic",
                contentScale = ContentScale.Crop
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstcomposeTheme {
        CreateBizCard()
    }
}
