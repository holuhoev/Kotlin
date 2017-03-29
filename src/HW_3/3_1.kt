package HW_3

import java.util.*

// TODO -------------------------------------- 1 --------------------------------------
/** Задача 3-1: (2 балла)

на вход программы приходит list целых.
Программа считает среднее для n выбранных элементов коллекции.
Затем случайно перемешивает элементы списка, считает
среднее для n элементов на тех же позициях, что были выбраны в первый раз.
Такая процедура повторяется n раз.
Затем вычисляется среднее по всем замерам.

*/
fun main(args: Array<String>)
{
    var result = meanOfList(listOf(12, 34, 1, 2, 3, 4, 5, 6, 7, 100, 213, 31, 11, 34))

    println(result);
}

fun meanOfList(list: List<Int>): Double
{
    var n = getN(list.size)
    var replaces = generateReplaces(n)
    var mean = 0.0
    var sum_means = 0.0;

    for (i in 0..n)
    {
        replaces.forEach {
            mean += list[it];
        }

        mean /= n
        sum_means += mean

        Collections.shuffle(list);
    }


    return sum_means / n
}

fun getN(limit: Int): Int
{

    while (true)
    {
        try
        {
            print("Введите N: ")
            val result = readLine()!!.toInt()
            if (result > 0 && result < limit)
                return result
            else
                throw Exception()
        } catch (e: Exception)
        {
            println("Неверный ввод!")
        }
    }
}

fun generateReplaces(n: Int): List<Int>
{
    var result: MutableList<Int> = mutableListOf()
    var rand = Random()
    for (i in 0..n)
        result.add(rand.nextInt(n))
    return result
}

