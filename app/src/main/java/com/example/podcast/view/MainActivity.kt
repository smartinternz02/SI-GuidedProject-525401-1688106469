package com.example.podcast.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.podcast.viewmodel.PodcastPlayer
import com.example.podcast.R
import com.example.podcast.ui.theme.PodcastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodcastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    playAudio(this)
                }
            }
        }
    }
}


@SuppressLint("DiscouragedApi")
@Composable
fun ImageCard(
    title: String,
    painter: Painter,
    audioFile: MediaPlayer,
    context: Context
) {
    Button(onClick = { context.startActivity(
        Intent(context, PodcastPlayer::class.java).putExtra("title", title)
    ) }, modifier = Modifier.background(color=Color.LightGray)) {
        Card(

            elevation = 12.dp,
            border = BorderStroke(2.dp, Color.Gray),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(210.dp)
        ) {
            val mp: MediaPlayer = audioFile

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .width(230.dp)
                )

                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                )

            }

        }
    }
}


@Composable
fun playAudio(context: Context) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Gray)) {
        Row(modifier = Modifier.height(60.dp)){
            Image(
                painter = painterResource(id = R.drawable.podcast_login),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(130.dp),
            )
            Box(contentAlignment = Alignment.Center){
                Text(text = "PodCast+",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 9.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    style = MaterialTheme.typography.h1,
                    letterSpacing = 0.1.em
                )
            }
        }
        
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ){

                ImageCard(
                    title = "GaurGopalDas Returns To TRS - Life, Monkhood & Spirituality",
                    painter = painterResource(id = R.drawable.img),
                    audioFile = MediaPlayer.create(context, R.raw.audio),
                    context = context
                )


            ImageCard(
                title = "Haunted Houses, Evil Spirits & The Paranormal Explained | Sarbajeet Mohanty",
                painter = painterResource(id = R.drawable.img_1),
                audioFile = MediaPlayer.create(context, R.raw.audio_1),
                context = context
            )

            ImageCard(
                title = "Kaali Mata ki kahani - Black Magic & Aghoris ft. Dr Vineet Aggarwal",
                painter = painterResource(id = R.drawable.img_2),
                audioFile = MediaPlayer.create(context, R.raw.audio_2),
                context = context
            )

            ImageCard(
                title = "Tantra Explained Simply | Rajarshi Nandy - Mata, Bhairav & Kamakhya Devi",
                painter = painterResource(id = R.drawable.img_3),
                audioFile = MediaPlayer.create(context, R.raw.audio_3),
                context = context
            )

            ImageCard(
                title = "Complete Story Of Shri Krishna - Explained In 20 Minutes",
                painter = painterResource(id = R.drawable.img_4),
                audioFile = MediaPlayer.create(context, R.raw.audio_4),
                context = context
            )

            ImageCard(
                title = "Mahabharat Ki Poori Kahaani - Arjun, Shri Krishna & Yuddh - Ami Ganatra ",
                painter = painterResource(id = R.drawable.img_5),
                audioFile = MediaPlayer.create(context, R.raw.audio_5),
                context = context
            )
        }
    }
}