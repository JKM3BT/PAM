package com.example.papierkamiennozyce



fun main() {
    while (true) {
        var x = readln()


        var game: Int = when (x) {
            "papier" -> 1
            "kamien" -> 2
            "nozyce" -> 3
            else -> 0
        }
        var opponent = (1..3).random()
        if (game == 1 && opponent == 2) {
            println("Wygrywasz!")
        } else if (game == 2 && opponent == 3) {
            println("Wygrywasz!")
        } else if (game == 3 && opponent == 1) {
            println("Wygrywasz!")
        } else {
            if (game == 1 && opponent == 3) {
                println("Przegrywasz. Przeciwnik wybral nozyce")
            } else if (game == 2 && opponent == 1) {
                println("Przegrywasz. Przeciwnik wybral papier")
            } else if (game == 3 && opponent == 2) {
                println("Przegrywasz. Przeciwnik wybral kamien")
            } else {
                println("remis")
            }
        }
    }
}
