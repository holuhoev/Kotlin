package HW_3

import java.util.*

/**
 * Задача 3-3: (3 балла)

На вход программы приходит: list с целыми, set с целыми. Числа в обеих коллекциях выбраны из одного набора,
но встречаться могут не все числа из набора, повторы допускаются.
Пример: list = [1, 2, 3, 2, 2, 4, 6], set = [1, 2, 4], набор: 1..6
Программа формирует список списков такой, что:
в нем содержится столько списоков, сколько элементов в set,
для каждого элемента из set в соответствующем списке хранятся номера,
под которыми такой элемент встречался в исходном list.
пример результата(для приведенных выше входных данных): [[0],[1,3,4],[5]]
 */

fun main(args: Array<String>)
{
    val list = listOf(1, 2, 3, 2, 2, 4, 6)
    val set = setOf(1, 2, 4)

    val res = mutableListOf<MutableList<Int>>()

    for (i in 0..set.size - 1)
        res.add(mutableListOf<Int>())

    for (i in 0..list.size - 1)
        if (set.contains(list[i])) res[set.indexOf(list[i])].add(i)


    res.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }

}
