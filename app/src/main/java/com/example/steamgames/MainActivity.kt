package com.example.steamgames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steamgames.data.GamesDataSource
import com.example.steamgames.model.Game
import com.example.steamgames.ui.theme.SteamGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SteamGamesTheme {
                SteamApp()
            }
        }
    }
}

@Composable
fun SteamApp(gamesList: List<Game> = GamesDataSource().getGamesList()){
    Scaffold(
        topBar = {
            TopAppBar()
        },

    ) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(it)
        ){
            items(gamesList){ game ->
                GameCard(game = game)

            }
        }
    }
}

@Composable
fun TopAppBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.secondary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .padding(4.dp),
            painter = painterResource(id = R.drawable.steam_logo),
            contentDescription = stringResource(
            id = R.string.app_name)
        )
        Text( modifier = Modifier.padding(8.dp),
              text = stringResource(id = R.string.app_name),
              style = MaterialTheme.typography.h4,
              color = Color.White,
        )
    }
}

@Composable
fun GameCard(game: Game){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp), elevation = 4.dp){
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.width(150.dp),
                painter = painterResource(id = game.imageDrawableResId),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(id = game.nameStringResId
                ))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text(text = stringResource(id = game.nameStringResId))
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = stringResource(id = game.priceStringResId),
                    color = if(game.isOnOffer ) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onSurface)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SteamGamesTheme {
        GameCard(game = GamesDataSource().getGamesList()[8])
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SteamGamesTheme {
        SteamApp()
    }
}
