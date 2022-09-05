package com.otaviomiguel.software.lotofacil.core.domains

abstract class AbstractGame {
    abstract val gameName: ApiGameEnum
    abstract val numbersAmount: Int
    abstract val minNumber: Int
    abstract val maxNumber: Int
    abstract val gameApiEndpoint: String
    val numbers: HashSet<Int> = HashSet()

    fun addNumber(number: Int) {
        if (numbersAmount == numbers.size) {
            throw Exception("List is already full")
        } else if (number < minNumber) {
            throw Exception("Number is too small")
        } else if (number > maxNumber) {
            throw Exception("Number is too big")
        } else {
            numbers.add(number)
        }
    }

    override fun toString(): String {
        return "$gameName(numbersAmount=$numbersAmount, minNumber=$minNumber, maxNumber=$maxNumber, numbers=$numbers)"
    }

}