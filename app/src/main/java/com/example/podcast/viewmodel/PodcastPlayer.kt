package com.example.podcast.viewmodel

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.podcast.R
import com.example.podcast.ui.theme.PodcastTheme
import com.example.podcast.view.MainActivity

class PodcastPlayer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                PodcastTheme {
                    Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                        val title :String = intent.getStringExtra("title").toString()
                        audioRedirect(title = title, context = this)
                    }
                }
            }
    }
}

@Composable
fun audioRedirect(
    title: String,
    context: Context
){
    if(title == "GaurGopalDas Returns To TRS - Life, Monkhood & Spirituality")
        audioPlayer(title = title, context = context, audio = MediaPlayer.create(context, R.raw.audio), painter = painterResource(
            id = R.drawable.img
        ))
    else if(title == "Haunted Houses, Evil Spirits & The Paranormal Explained | Sarbajeet Mohanty")
        audioPlayer(title = title, context = context, audio = MediaPlayer.create(context, R.raw.audio_1), painter = painterResource(
            id = R.drawable.img_1
        ))
    else if(title == "Kaali Mata ki kahani - Black Magic & Aghoris ft. Dr Vineet Aggarwal")
        audioPlayer(title = title, context = context, audio = MediaPlayer.create(context, R.raw.audio_2), painter = painterResource(
            id = R.drawable.img_2
        ))
    else if(title == "Tantra Explained Simply | Rajarshi Nandy - Mata, Bhairav & Kamakhya Devi")
        audioPlayer(title = title, context = context, audio = MediaPlayer.create(context, R.raw.audio_3), painter = painterResource(
            id = R.drawable.img_3
        ))
    else if(title == "Complete Story Of Shri Krishna - Explained In 20 Minutes")
        audioPlayer(title = title, context = context, audio = MediaPlayer.create(context, R.raw.audio_4), painter = painterResource(
            id = R.drawable.img_4
        ))
    else
        audioPlayer(title = title, context = context, audio = MediaPlayer.create(context, R.raw.audio_5), painter = painterResource(
            id = R.drawable.img_5
        ))
}

@Composable
fun audioPlayer(title :String, audio: MediaPlayer, painter: Painter, context: Context) {
    Card(modifier = Modifier.fillMaxSize().background(color = Color.LightGray),
    ) {
        Row{
            Box(contentAlignment = Alignment.Center){
                IconButton(onClick = {context.startActivity(
                    Intent(context, MainActivity::class.java))
                }) {
                    Icon(painter = painterResource(id = R.drawable.backarrow), contentDescription = "",
                        Modifier
                            .size(80.dp)
                            .padding(start = 30.dp, end = 10.dp))
                }
            }

        }
        
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Card(modifier = Modifier.height(180.dp)){
                Image(
                    painter = painter,
                    contentDescription = "",
                    )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 30.dp, end = 20.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                IconButton(onClick = {audio.start()}) {
                    Icon(painter = painterResource(id = R.drawable.play), contentDescription = "", Modifier.size(50.dp))
                }
                IconButton(onClick = {audio.pause()}) {
                    Icon(painter = painterResource(id = R.drawable.pause), contentDescription = "", Modifier.size(50.dp))
                }
            }
        }
    }
}