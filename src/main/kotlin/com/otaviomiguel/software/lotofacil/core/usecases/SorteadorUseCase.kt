package com.otaviomiguel.software.lotofacil.core.usecases

import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.domains.GameAnalysis
import kotlin.random.Random

class SorteadorUseCase(gameAnalysis: GameAnalysis) {
    private val valores: MutableList<Int> = ArrayList()
    private val referenceGame: AbstractGame

    init {
        for (number in gameAnalysis.recoverAllNumbers()) {
            var weigth = number.weigth
            while (weigth > 0) {
                weigth--
                valores.add(number.number)
            }
        }

        referenceGame = gameAnalysis.recoverAllGames().first()
    }

    fun sortear() : Set<Int> {

        val valoresSorteados: MutableSet<Int> = HashSet()
        val random: Random = Random

        while (valoresSorteados.size < referenceGame.numbersAmount) {
            valoresSorteados.add(valores[random.nextInt(valores.size)])
        }

        return valoresSorteados.sorted().toSet()
    }
}