package com.example.funkcjadataklas

data class Pizza(val type: String, var price: Float, val client: String)
class Dog(val name: String, var age: Int = 0){
    fun bark(){
        println("$name Hał, Hał, Hau, Hau, Woof, Woof")
    }
}
fun main(){
    val Margharitta: Pizza = Pizza(type = "Margharitta",price = 30.00f,client = "Filipa")
    makePizza(Margharitta)
    val burek = Dog(name = "Burek")
    burek.bark()
    val reksio = Dog(name = "Reksio")
    reksio.age = 15
    reksio.bark()
//    println("Python jest cool")
//    makePizza(type = "Margharitta", price = 30, client = "Szymon")
//    makePizza(type = "Pepperoni", price = 35, client = "Zosia")
}
//fun foo() : String{
//    return "vdbyugbavavgahana"
//}
fun makePizza(pizza: Pizza){
    when(pizza.client.last()){
        'a' -> {println("Jesteś kobietą, więc masz zniżkę")
                println("Pizza ${pizza.type}, cena: ${pizza.price}, klient: ${pizza.client}")
                println("Ty płacisz ${pizza.price-10}\n")
        }
        else -> println("Pizza ${pizza.type}, cena: ${pizza.price}, klient: ${pizza.client}")
    }
}