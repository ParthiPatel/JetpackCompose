package com.example.jetpackcompose1

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateForm()
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    //14/05/2022
    val color = remember {
        mutableStateOf(Color.Yellow)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color.value)
            .clickable {
                color.value =
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
            }
    ) {
        Card(
            modifier = modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(10.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(15.dp),
            elevation = 10.dp
        ) {

            Box(
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                Image(
                    modifier = modifier.align(Alignment.Center),
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .wrapContentHeight(Alignment.CenterVertically)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .align(Alignment.BottomCenter)
                        .padding(4.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 1f
                            )
                        ),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    /*Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )*/
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Cyan,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("J")
                            }

                            append("etpack ")

                            withStyle(
                                style = SpanStyle(
                                    color = Color.Cyan,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("C")
                            }
                            append("ompose ")

                        },
                        color = Color.White,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline
                        /*style = TextStyle(color = Color.White, fontSize = 16.sp)*/
                    )
                }
            }

        }
    }


}

@Composable
fun CreateForm() {
    // ColumnRowBox()


    /* val painter = painterResource(id = R.drawable.sample)
     val contentDescription = "hello"
     val title = "Compose Training"

     ImageCard(
         painter = painter, contentDescription = contentDescription, title = title
     )*/

    Textfield_button_snackbar()
}

@Composable
fun Textfield_button_snackbar() {
//14/05/2022

    /*Snackbar {
        Text(text = "Hello this is snackbar")
    }*/
    Column(modifier = Modifier.fillMaxSize()) {
        val scaffoldState = rememberScaffoldState()

        var textFieldStateOf by remember {
            mutableStateOf("")
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                TextField(value = textFieldStateOf, label = {
                    Text(text = "Enter your name")
                }, onValueChange = {
                    textFieldStateOf = it
                },
                    singleLine = true,
                    modifier = Modifier.fillMaxSize()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { }) {
                    Text(text = "Button")
                }
            }
        }
    }

}

@Composable
fun ColumnRowBox() {
    //7/05/2022
    /*Layouts:
            Column : arrange elements vertically
                        horizontalAlignment
                        verticalArrangement
            Row :arrange items horizontally
                        horizontalArrangement
                        verticalAlignment
            Box : to stack elements.*/
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color.LightGray)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Hello", modifier = Modifier.background(Color.Yellow))

            //note : below is use for to add space just like margin
            Spacer(
                modifier = Modifier
                    .height(4.dp)
                    .background(Color.Green)
            )

            Text(text = "Parthi", modifier = Modifier.padding(2.dp))
            Text(text = "Patel", modifier = Modifier.padding(2.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color.Magenta)
                .padding(5.dp)
                .border(5.dp, Color.Green, RectangleShape)
                .padding(10.dp)
                .border(5.dp, Color.Yellow)
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LocalContext.current
            Text(
                text = "Sangam",
                modifier = Modifier
                    .padding(2.dp)
                    .clickable { Log.e("parthi", "-=-=-=-=-=-=-=-=>>>>>") })
            Text(
                text = "Mobile", modifier = Modifier
                    .padding(2.dp)
                    .clickable(interactionSource = MutableInteractionSource(),
                        indication = null,
                        enabled = true,
                        onClick = { Log.e("parthi", "-=-=-=-=-=-=-=-=>>>>>") })
            )
            Text(text = "CRM", modifier = Modifier.padding(2.dp))
        }

        Box {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(Color.Cyan)
            )
            Box(
                Modifier
                    .matchParentSize()
                    .padding(top = 20.dp, bottom = 20.dp)
                    .background(Color.Yellow)
            )
        }

    }
}

@Composable
fun ToastMessage(context: Context, message: String) {
    Toast.makeText(
        context,
        message,
        Toast.LENGTH_LONG
    ).show()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose1Theme {
        CreateForm()
    }
}