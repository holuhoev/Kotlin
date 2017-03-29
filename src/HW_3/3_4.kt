package HW_3

/**
 * Задача 3-4: (1 балл)

На вход программы приходит строка и два целых a, b.
Программа выдает подстроку, начинающуюся с символа под номером a,
заканчивающуюся символом под номером b.
 */

fun getInt(varName : String) : Int {

    while (true) {
        try {
            print("Введите $varName: ")
            val result = readLine()!!.toInt()
            if (result > -1)
                return result
            else
                throw Exception()
        } catch (e: Exception) {
            println("Неверный ввод!")
        }
    }
}
fun main(args: Array<String>) {
    println("Введите строку:")
    val s: String = readLine()!!

    val a: Int  = getInt("a")
    val b: Int = getInt("b")

    if (a >= b)
        throw Exception()

    println(s.substring(a,b))
}
