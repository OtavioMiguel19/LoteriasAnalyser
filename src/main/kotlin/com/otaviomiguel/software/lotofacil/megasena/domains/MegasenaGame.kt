package com.otaviomiguel.software.lotofacil.megasena.domains

import com.otaviomiguel.software.lotofacil.core.configs.ApiEndpoints
import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.domains.ApiGameEnum

class MegasenaGame : AbstractGame() {

    override val gameName: ApiGameEnum
        get() = ApiGameEnum.megasena
    override val numbersAmount: Int
        get() = 6
    override val minNumber: Int
        get() = 1
    override val maxNumber: Int
        get() = 60
    override val gameApiEndpoint: String
        get() = ApiEndpoints.loteriascaixa + gameName.apiCode
}
