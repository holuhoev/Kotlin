package HW_1

/** Написать такую простую программу:
На вход приходит строка типа
«aaaaaabbbbbaccccddeeeee»
На выход выдается закодированная строка типа
«a6b5a1c4d2e5»
(каждый символ кодируется своим обозначением и
количеством повторений)
Как можно улучшить такой способ кодирования? (не писать единицу)*/

fun main(args: Array<String>)
{
    val str: String = "aaaaaabbbbbaccccddeeeee"
    var result = ""


    var i = 0

    while (i < str.length)
    {
        var prev = str[i]
        var numb: Int = 0

        while (i < str.length && prev == str[i])
        {
            numb++
            i++
        }

        result += prev
        result += numb.toString()

    }

    println(result)

}