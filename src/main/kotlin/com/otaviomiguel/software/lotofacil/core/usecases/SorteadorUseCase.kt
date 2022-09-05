package com.otaviomiguel.software.lotofacil.core.usecases

import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.domains.GameAnalysis
import kotlin.random.Random

class SorteadorUseCase(gameAnalysis: GameAnalysis) {
    private val valores: MutableList<Int> = ArrayList()
    private val referenceGame: AbstractGame
    private val analysis: GameAnalysis;

    init {
        for (number in gameAnalysis.recoverAllNumbers()) {
            var weigth = number.weigth
            while (weigth > 0) {
                weigth--
                valores.add(number.number)
            }
        }

        referenceGame = gameAnalysis.recoverAllGames().first()
        analysis = gameAnalysis
    }

    fun sortear(): Set<Int> {

        val valoresSorteados: MutableSet<Int> = HashSet()
        val random: Random = Random

        while (valoresSorteados.size < referenceGame.numbersAmount) {
            valoresSorteados.add(valores[random.nextInt(valores.size)])
        }

        return valoresSorteados.sorted().toSet()
    }

    fun sortearWithNoRepetitions(qty: Int): Set<Set<Int>> {
        val games: MutableSet<Set<Int>> = HashSet()

        while (games.size < qty) {
            val game = sortear()
            if (analysis.recoverAllGames().stream().noneMatch { game.containsAll(it.numbers) }) {
                games.add(game)
            }
        }

        return games;
    }
}