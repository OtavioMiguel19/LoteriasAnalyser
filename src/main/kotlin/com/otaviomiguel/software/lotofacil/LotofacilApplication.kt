package com.otaviomiguel.software.lotofacil

import com.otaviomiguel.software.lotofacil.core.usecases.SorteadorUseCase
import com.otaviomiguel.software.lotofacil.lotofacil.gateways.LotofacilApiGameReader
import com.otaviomiguel.software.lotofacil.megasena.gateways.MegasenaApiGameReader
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LotofacilApplication

fun main(args: Array<String>) {
    runApplication<LotofacilApplication>(*args)

//    val reader = LotofacilCsvGameReader("C:\\Projetos\\Lotofacil\\src\\main\\resources\\csv\\lotofacil\\20-08-22.csv")
    println("Lotofacil: " + SorteadorUseCase(LotofacilApiGameReader().read()).sortear())
    println("Megasena: " + SorteadorUseCase(MegasenaApiGameReader().read()).sortear())
}
