package com.example.steamgames.data

import com.example.steamgames.R
import com.example.steamgames.model.Game

class GamesDataSource() {

    fun getGamesList(): List<Game>{
        return listOf(
            Game(R.string.csgo, R.drawable.csgo, R.string.csgo_price),
            Game(R.string.dota, R.drawable.dota, R.string.dota_price),
            Game(R.string.elden_ring, R.drawable.elden_ring, R.string.elden_ring_price),
            Game(R.string.eurotruck, R.drawable.eurotruck, R.string.eurotruck_price, true),
            Game(R.string.fifa, R.drawable.fifa, R.string.fifa_price, true),
            Game(R.string.hogwarts, R.drawable.hogwarts, R.string.hogwarts_price),
            Game(R.string.no_mans_sky, R.drawable.no_mans_sky, R.string.no_mans_sky_price, true),
            Game(R.string.pubg, R.drawable.pubg_battlegrounds, R.string.pubg_price),
            Game(R.string.re4, R.drawable.re4, R.string.re4_price),
            Game(R.string.rust, R.drawable.rust, R.string.rust_price),
            Game(R.string.stardew_valley, R.drawable.stardew_valley, R.string.stardew_valley_price),

            )
    }
}