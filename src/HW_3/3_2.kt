package HW_3

/**
 * Задача 3-2: (2 балла)

На вход программы приходит строка.
Программа определяет, является ли строка палиндромом.
Результат выдается в виде строки "да/нет"
 */
// TODO -------------------------------------- 2 --------------------------------------

fun main(args: Array<String>) {
    println("Введите строку:")
    val s: String = readLine()!!

    if(isPalindrom(s))
        println("Да")
    else
        println("Нет")
}

fun isPalindrom(s: String) : Boolean
{
    return (StringBuilder(s).reverse().toString() == (s))
}