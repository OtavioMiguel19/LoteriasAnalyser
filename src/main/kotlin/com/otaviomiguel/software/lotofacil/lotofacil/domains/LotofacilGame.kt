package com.otaviomiguel.software.lotofacil.lotofacil.domains

import com.otaviomiguel.software.lotofacil.core.configs.ApiEndpoints
import com.otaviomiguel.software.lotofacil.core.domains.AbstractGame
import com.otaviomiguel.software.lotofacil.core.domains.ApiGameEnum

class LotofacilGame : AbstractGame() {

    override val gameName: ApiGameEnum
        get() = ApiGameEnum.lotofacil
    override val numbersAmount: Int
        get() = 15
    override val minNumber: Int
        get() = 1
    override val maxNumber: Int
        get() = 25
    override val gameApiEndpoint: String
        get() = ApiEndpoints.loteriascaixa + gameName.apiCode
}
