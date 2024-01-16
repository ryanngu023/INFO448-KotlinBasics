package edu.uw.basickotlin

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(arg: Any): String {
    when (arg) {
        is String -> {
            if (arg == "Hello") {
                return "world"
            } else {
                return "Say what?"
            }
        }
        is Int -> {
            when (arg) {
                0 -> return "zero"
                1 -> return "one"
                in 2..10 -> return "low number"
                else -> return "a number"
            }
        }
    }
    return "I don't understand"
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(lhs: Int, rhs: Int): Int {
    return lhs + rhs
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(lhs: Int, rhs: Int): Int {
    return lhs - rhs
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(lhs: Int, rhs: Int, op: (Int, Int) -> Int) {
    return op(lhs, rhs)
}

// write a class "Person" with first name, last name and age
class Person(var firstname: String, var lastname: String, var age: Int) {
    val debugString(): String {

    }
}
// write a class "Money"
class Money(var amount: Int, var currency: String) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Amount input cannot be negative")
        }
        if (currency !in listof("USD", "EUR", "CAN", "GBP")) {
            throw IllegalArgumentException("Currency is an invalid value")
        }
    }

    fun convert(other: String): Money {
        if (other !in listof("USD", "EUR", "CAN", "GBP")) {
            throw IllegalArgumentException("Currency is an invalid value")
        }
        if (this.currency == other) {
            return Money(this.amount, other)
        }
        else
    }
}