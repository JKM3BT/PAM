package com.example.myapplication

fun order(){
    println("Jaką chcesz pizzę?")
    val type = readln()
    println("Jaki rozmiar?")
    val size = readln()
    println("jakiś napój?")
    val drink = readln()
    println("I jak się Pani/Pan nazywa?")
    var name = readln()
    println("I kontakt do Pani/Pana?")
    var number = readln()
    val pizza : Pizza = Pizza(type = type, price = 0, size = size)
    val napoj : Napoj = Napoj(name = drink, price = 0)

}
data class Pizza(val type: String, var price: Int, val size: String)
data class Napoj(val name: String, val price: Int)

class Client(val name: String, val number: String){

}

fun main(){
    order()
}