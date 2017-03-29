package HW_3

/**
 * Задача 3-4: (1 балл)

На вход программы приходит строка и два целых a, b.
Программа выдает подстроку, начинающуюся с символа под номером a,
заканчивающуюся символом под номером b.
 */


fun main(args: Array<String>) {
    println("Введите строку:")
    val s: String = readLine()!!

    try
    {

        val a: Int = getInt("a")
        val b: Int = getInt("b")

        println(s.substring(a,b))

        if (a >= b)
            throw Exception("Неверный формат")
    }
    catch (e:Exception)
    {
        println("Error: ${e.message}")
    }
}

fun getInt(name:String):Int{
    println("Введите $name")
    val result = readLine()!!.toInt()

    if(result < 0)
        throw Exception("Введите число")
    return result
}