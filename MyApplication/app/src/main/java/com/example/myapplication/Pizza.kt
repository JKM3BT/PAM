package com.example.myapplication

fun order(){
    println("Jaką chcesz pizzę?")
    val type = readln()
    println("Jaki rozmiar?")
    val size = readln()
    println("jakiś napój?")
    val drink = readln()
    println("I jak się Pani/Pan nazywa?")
    val name = readln()
    println("I kontakt do Pani/Pana?")
    val number = readln()
    val pizza = Pizza(type = type, price = 0, size = size)
    val napoj = Napoj(name = drink, price = 0)
    val client = Client(name = name, number  = number)
    if (pizza.size == "Big"){
        println("${pizza.type}, ${pizza.size}, ${pizza.price+25}")
    }
    else{
        println("${pizza.type}, ${pizza.size}, ${pizza.price}")
    }
    println("${napoj.name}, ${napoj.price}")
    println("${client.name}, +48${client.number}")

}
data class Pizza(val type: String, var price: Int, val size: String)
data class Napoj(val name: String, val price: Int)

data class Client(val name: String, val number: String)

fun main(){
    order()
}