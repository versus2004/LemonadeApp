package com.example.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeLogic()
            }
        }
    }
}

@Composable
fun Lemonade(  step : Int , ImageResource:Int ,Text:String ,  onImageClick: () ->Unit ){


    Column(Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .background(color = Color(0xFF98FF98), RoundedCornerShape(35.dp))
                .padding(30.dp)) {
                                            Button(onClick = onImageClick ,     colors = ButtonDefaults.buttonColors(
                                                containerColor = Color.Black.copy(
                                                    alpha = 0.0F,
                                                ),
                                            )) {
                                                Image(painter = painterResource(id = ImageResource), contentDescription = null)

                                            }
        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(Text)

    }

}

@Composable
fun LemonadeLogic(){
    var squeeze by remember { mutableStateOf(0) }
    var step by remember { mutableStateOf(1) }

    when(step){
        1-> Lemonade(1,ImageResource = R.drawable.lemon_tree, Text = "Tap the lemon to tree to select a lemon" , onImageClick = {step=step+1; } )
        2-> Lemonade(2,ImageResource = R.drawable.lemon_squeeze, Text = "Keep clicking to squeeze the lemon" ,onImageClick = { squeeze++; if(squeeze==(2..4).random()){step++} } )
        3-> Lemonade(step = 3  , ImageResource =R.drawable.lemon_drink , Text ="Tap the lemonade to drink it", onImageClick = {step=step+1} )
        4-> Lemonade(step = 4, ImageResource = R.drawable.lemon_restart, Text ="Tap the Empty glass to start again" , onImageClick = { step=1} )


        }
    }



