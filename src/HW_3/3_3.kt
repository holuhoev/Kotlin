package HW_3

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

fun main(args: Array<String>) {
    val list: List<Int> = listOf(1, 2, 1, 8, 2, 3, 4, 3, 4, 5, 6, 5, 6, 7, 2)
    val set: Set<Int> = setOf(1, 2, 5, 8)

    var result = Array(set.size) { IntArray(list.size) }

    for (i in 0..result.size - 1)
        for (j in 0..result.size - 1)
            result[i][j] = -1
    set.elementAt(1)

    for (i in 0..set.size - 1) {
        for (j in 0..list.size - 1)
            if (list[j] == set.elementAt(i))
                result[i][j] = j
    }

    result.forEach {
        it.filter { it > 0 }.forEach { print("$it ") }
        print("\n")
    }
}
