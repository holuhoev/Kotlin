package HW_1

/** Задача 5

Дан список (listOf) строковых значений (слова из

3-5 букв каждое).

Значения списка (слова) сгенерировать с помощью

random (из латинских маленьких букв, см. range).

Найти все повторы и вывести список без повторов,

отдельно повторяющиеся элементы, количество

повторений для каждого, их положение в исходном

списке.*/

import  java.util.*

private val random = Random()
val COUNT = 10000

fun main(args: Array<String>)
{
    val list = mutableListOf<String>()
    var str: String

    //generate strings
    for (i in 0..COUNT - 1)
    {
        str = ""
        for (j in 0..2)
        {
            val number = random.nextInt(122 + 1 - 97) + 97
            val c = number.toChar()
            str += c;
        }
        list.add(str)
    }

    //2
    val set = list.toHashSet()
    println("Список без повторов:")
    set.forEach { println(it) }

    println(set.size)


    println(list.size)
    //3
    val map = HashMap<String, MutableList<Int>>()

    for (i in 0..COUNT - 1)
    {
        val it = list[i]


        if (list.indexOfFirst { a: String -> a.equals(it) } != list.indexOfLast { a: String -> a.equals(it) })
        {
            if (map[it] == null)
                map[it] = mutableListOf(0)

            map[it]!![0]++
            map[it]!!.add(i)

        }
    }

    for ((string, properties) in map)
    {
        println("Строка:    $string     ${properties[0]} повторений , индексы в исходном списке: ")
        for (i in 1..properties.size - 1)
        {
            print("${properties[i]} ")
        }
        println()
    }

}