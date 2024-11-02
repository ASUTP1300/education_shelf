package ru

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MSSQLApp

fun main(args: Array<String>) {
    runApplication<MSSQLApp>(*args)
}