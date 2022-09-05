package com.otaviomiguel.software.lotofacil.core.gateways

import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.domains.GameAnalysis
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.FileReader
import java.io.Reader


abstract class CsvGameReader(path: String) {
    private val csvParser: CSVParser

    init {
        val reader: Reader = FileReader(path)
        val bufferedReader = BufferedReader(reader)

        csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT.withDelimiter(';'))
    }

    fun read() : GameAnalysis {
        val analysis = GameAnalysis()
        for (csvRecord in csvParser) {
            val game = recoverGame()
            var index = 0
            while (index < game.numbersAmount) {
                game.addNumber(csvRecord.get(index).toString().toInt())
                index++
            }
            analysis.addGame(game)
        }

        return analysis
    }

    abstract fun recoverGame() : AbstractGame;
}