package com.otaviomiguel.software.lotofacil.core.gateways

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.domains.ApiGame
import com.otaviomiguel.software.lotofacil.core.domains.GameAnalysis
import okhttp3.*
import okio.IOException
import java.util.concurrent.CountDownLatch


abstract class ApiGameReader {

    private val client = OkHttpClient()

    fun read(): GameAnalysis {
        val analysis = GameAnalysis()

        val request = Request.Builder().url(recoverGame().gameApiEndpoint).build()

        val countDownLatch = CountDownLatch(1)

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val gson = Gson()

                val itemType = object : TypeToken<List<ApiGame>>() {}.type
                val list = gson.fromJson<List<ApiGame>>(response.body.string(), itemType)

                for (item in list) {
                    val game = recoverGame()
                    var index = 0
                    while (index < game.numbersAmount) {
                        game.addNumber(item.dezenas[index])
                        index++
                    }
                    analysis.addGame(game)
                }

                countDownLatch.countDown()
            }
        })

        countDownLatch.await()
        return analysis
    }

    abstract fun recoverGame(): AbstractGame;
}