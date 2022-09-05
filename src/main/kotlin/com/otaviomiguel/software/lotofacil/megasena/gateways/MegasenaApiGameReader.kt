package com.otaviomiguel.software.lotofacil.megasena.gateways

import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.gateways.ApiGameReader
import com.otaviomiguel.software.lotofacil.megasena.domains.MegasenaGame

class MegasenaApiGameReader : ApiGameReader() {
    override fun recoverGame(): AbstractGame {
        return MegasenaGame()
    }
}