package HW_1

import java.util.*

fun main(args: Array<String>)
{
    var infixExpression: String

    while (true)
    {
        print("\nВведите выражение, где символы разделенны символом пробела(или \"q\" чтобы выйти) :")
        infixExpression = readLine()!!

        if (infixExpression == "q")
            break

        try
        {

            //переводим в польскую нотацию
            val OPN_expression: MutableList<String> = infixToOPN(infixExpression)

            //считаем по польской нотации
            val result = calculate(OPN_expression)

            println("\nРезультат: $result \n")

            print("Обратная польска нотация:")
            OPN_expression.forEach { print("$it ") }


        } catch (e: Exception)
        {
            println("Sorry, error: ${e.message}")
        }
    }
}

//считает значения выражения в обратной польской записи
fun calculate(expr: MutableList<String>): Double
{
    val stackMachine: MutableList<Double> = mutableListOf()

    expr.forEach {
        if (!isOperator(it))
        {
            stackMachine.add(it.toDouble())
        } else
        {
            try
            {
                val firstIndex = stackMachine.size - 1
                val secondIndex = stackMachine.size - 2

                /** Применяем операцию */
                val res = doOperation(it, stackMachine[secondIndex], stackMachine[firstIndex])

                stackMachine.removeAt(stackMachine.size - 1)
                stackMachine.removeAt(stackMachine.size - 1)

                /**кладем в стек результат применения бинарной операции*/
                stackMachine.add(res)
            } catch (e: Exception)
            {
                throw Exception("${e.message},Неккоректные данные")
            }
        }
    }

    //ответ на вершине стека
    return stackMachine[stackMachine.size - 1];
}

fun doOperation(oper: String, first: Double, second: Double): Double
{
    when (oper)
    {
        "*" -> return first * second
        "+" -> return first + second
        "-" -> return first - second
        "/" -> if (second == 0.0)
        {
            throw ArithmeticException()
        } else
            return first / second
        else ->
        {
            throw Exception("Не найден оператор")
        }
    }
}

//возвращает обратную польскую нотацию
fun infixToOPN(expr: String): MutableList<String>
{

    val outputExpression: MutableList<String> = mutableListOf()
    val operators: Stack<String> = Stack<String>()

    val list = expr.split(' ').toMutableList()

    if (!isCorrect(list))
        throw Exception("Ошибка, некорректные данные")

    for (i in 0..list.size - 1)
    {
        val elem = list[i]

        if (isOperator(elem) || isBracket(elem))
        {
            if (elem != "(" && operators.size > 0)
            {
                try
                {
                    if (elem == ")")
                    {
                        var operator = operators.pop()
                        while (operator != "(")
                        {
                            outputExpression.add(operator)
                            operator = operators.pop()

                        }
                    } else if (getPriority(elem) > getPriority(operators.peek()))
                        operators.push(elem)
                    else
                    {
                        while (operators.size > 0 && getPriority(elem) <= getPriority(operators.peek()))
                            outputExpression.add(operators.pop())

                        operators.push(elem)
                    }
                }catch (e:Exception)
                {
                    println("Ошибка в данных")
                }
            }
            else
                operators.push(elem)
        } else
            outputExpression.add(elem)
    }

    while (!operators.isEmpty())
        outputExpression.add(operators.pop())

    return outputExpression
}

fun isBracket(elem: String): Boolean
{
    return (elem == "(" || elem == ")")
}

fun getPriority(s: String): Byte
{
    when (s)
    {
        "(", ")" -> return 0
        "+", "-" -> return 1
        "*", "/" -> return 2
        else -> return 4
    }
}

fun isOperator(elem: String): Boolean
{
    return !(elem != "*" && elem != "-" && elem != "/" && elem != "+")
}

fun isCorrect(list: MutableList<String>): Boolean
{

    list.forEach {
        try
        {
            if (!isOperator(it) && !isBracket(it))
                it.toDouble()
        } catch (e: Exception)
        {
            println("Exception")
            return false
        }
    }

    return true
}
