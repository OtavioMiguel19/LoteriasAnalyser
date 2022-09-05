package com.otaviomiguel.software.lotofacil.core.domains

class GameAnalysis {
    private val allGames: MutableList<AbstractGame> = ArrayList()
    private val allNumbers: MutableSet<GameNumber> = HashSet()

    fun recoverAllGames(): List<AbstractGame> {
        return allGames;
    }

    fun recoverAllNumbers(): Set<GameNumber> {
        return allNumbers.sortedBy { n -> n.number }.toSet()
    }

    fun addGame(game: AbstractGame) {
        allGames.add(game)

        for (number in game.numbers) {
            val gameNumber = recoverNumber(number)
            allNumbers.remove(gameNumber)

            gameNumber.weigth += 1
            allNumbers.add(gameNumber)
        }
    }

    private fun recoverNumber(value: Int): GameNumber {
        return try {
            allNumbers.first { number -> number.number == value }
        } catch (e: NoSuchElementException) {
            GameNumber(value, 0)
        }
    }
}