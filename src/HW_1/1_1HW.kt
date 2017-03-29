package HW_1

import java.util.*

/**
 *
Дан список элементов (слова из букв латинского
алфавита)
Программа должна выдавать список списков, в
каждом под-списке которого находятся все слова,
начинающиеся с одной и той же буквы (первый
подсписок — „a“, последний - „z“)
 */

fun main(args: Array<String>)
{
    val list = listOf("abc", "aab", "yg", "bab", "qwe", "ewr", "bba", "yhqweh", "qwed");

    val map = HashMap<Char, MutableList<String>>()

    list.forEach {
        if (map[it[0]] == null)
            map[it[0]] = mutableListOf(it);
        else
            map[it[0]]!!.add(it)
    }

    for ((char, lst) in map)
    {
        lst.forEach { print("$it ") }
        println()
    }
}