package com.example.jetpackcompose1

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose1.ui.theme.JetpackCompose1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateForm()
        }
    }
}

@Composable
fun CreateForm() {
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
            val context = LocalContext.current
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
        Log.e("parthi", "DefaultPreview------->>>")
        CreateForm()
    }
}