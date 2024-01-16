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
fun mathOp(lhs: Int, rhs: Int, op: (Int, Int) -> Int): Int {
    return op(lhs, rhs)
}

// write a class "Person" with first name, last name and age
class Person(var firstName: String, var lastName: String, var age: Int) {
    val debugString: String = "[Person firstName:$firstName lastName:$lastName age:$age]"
}
// write a class "Money"
class Money(var amount: Int, var currency: String) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Amount input cannot be negative")
        }
        if (currency !in listOf("USD", "EUR", "CAN", "GBP")) {
            throw IllegalArgumentException("Currency is an invalid value")
        }
    }

    fun convert(other: String): Money {
        if (other !in listOf("USD", "EUR", "CAN", "GBP")) {
            throw IllegalArgumentException("Currency is an invalid value")
        }
        if (this.currency == other) {
            return Money(this.amount, other)
        }
        else {
            val usdConversion = when (currency) {
                "USD" -> 1.0
                "GBP" -> 0.5
                "EUR" -> 1.5
                "CAN" -> 1.25
                else -> 1.0
            }
            val usdAmount = this.amount / usdConversion
            val conversionRate = when (other) {
                "USD" -> 1.0
                "GBP" -> 0.5
                "EUR" -> 1.5
                "CAN" -> 1.25
                else -> 1.0
            }
            val convertedAmount = (usdAmount * conversionRate).toInt()
            return Money(convertedAmount, other)
        }
    }

    operator fun plus(other: Money): Money {
        return Money(this.amount + (other.convert(this.currency)).amount, this.currency)
    }
}