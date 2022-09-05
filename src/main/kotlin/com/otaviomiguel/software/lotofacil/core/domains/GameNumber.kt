package com.otaviomiguel.software.lotofacil.core.domains

data class GameNumber(
    val number: Int,
    var weigth: Int

) {
    override fun toString(): String {
        return "$number (weigth= $weigth)"
    }


}
