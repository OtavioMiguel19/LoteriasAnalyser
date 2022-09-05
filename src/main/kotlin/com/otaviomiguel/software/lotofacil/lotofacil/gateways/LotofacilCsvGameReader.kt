package com.otaviomiguel.software.lotofacil.lotofacil.gateways

import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.gateways.CsvGameReader
import com.otaviomiguel.software.lotofacil.lotofacil.domains.LotofacilGame

class LotofacilCsvGameReader(path: String) : CsvGameReader(path) {
    override fun recoverGame(): AbstractGame {
        return LotofacilGame()
    }
}