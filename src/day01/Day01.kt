package day01

import utils.*
import kotlin.math.absoluteValue
import kotlin.math.sign


fun main() {
    fun parse(r: String): Int {
        val sign = if (r.first() == 'L') -1 else 1
        return r.drop(1).toInt() * sign
    }

    fun move(current: Int, step: Int, modulo: Int = 100): Int {
        return (current + step + modulo).mod(modulo)
    }

    fun part1(input: List<Int>): Int {
        var value = 50
        var count = 0
        for (i in input) {
            value = move(value, i)
            if(value == 0)  {
                count++
            }
        }
        return count
    }

    fun part2(input: List<Int>): Int {
        var value = 50
        var count = 0
        for (i in input) {
            val prev = value
            val fullRotations = i.absoluteValue / 100
            value = move(value, i)
            val dir = (value - prev) * i.sign
            count += fullRotations
            if(value == 0 || (prev != 0 && dir < 0))  {
                count += 1
            }
        }
        return count
    }

    check(part1(readInput("test", "day01").map{ parse(it)}) == 3)
    println(part1(readInput("real", "day01").map{ parse(it)}))

    check(part2(readInput("test", "day01").map{ parse(it)}) == 6)
    print(part2(readInput("real", "day01").map{ parse(it)}))
}
