package HW_2

import HW_1.calculate
import java.beans.Expression
import java.util.*

/**
 * Спроектируйте интерфейс Calculator, который бы позволял использовать различные реализации калькулятора для выражений,
 * заданных строкой.
Оберните код, реализованный вами при решении задачи первого занятия в класс CalculatorImpl,
реализующий интерфейс Calculator.
Разработайте функцию main для тестирования.
 * */

interface Calculator
{
    public fun calculate(expression: String): Double
}

class CalculatorImpl : Calculator
{

    override fun calculate(expression: String): Double
    {
        var result = 0.0
        try
        {

            //переводим в польскую нотацию
            val OPN_expression: MutableList<String> = infixToOPN(expression)

            //считаем по польской нотации
            result = calc(OPN_expression)


        } catch (e: Exception)
        {
            println("Sorry, error: ${e.message}")
        }
        return result
    }

    //считает значения выражения в обратной польской записи
    private fun calc(expr: MutableList<String>): Double
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

    private fun doOperation(oper: String, first: Double, second: Double): Double
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
    private fun infixToOPN(expr: String): MutableList<String>
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
                    } catch (e: Exception)
                    {
                        println("Ошибка в данных")
                    }
                } else
                    operators.push(elem)
            } else
                outputExpression.add(elem)
        }

        while (!operators.isEmpty())
            outputExpression.add(operators.pop())

        return outputExpression
    }

    private fun isBracket(elem: String): Boolean
    {
        return (elem == "(" || elem == ")")
    }

    private fun getPriority(s: String): Byte
    {
        when (s)
        {
            "(", ")" -> return 0
            "+", "-" -> return 1
            "*", "/" -> return 2
            else -> return 4
        }
    }

    private fun isOperator(elem: String): Boolean
    {
        return !(elem != "*" && elem != "-" && elem != "/" && elem != "+")
    }

    private fun isCorrect(list: MutableList<String>): Boolean
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

}

fun main(args: Array<String>)
{
    var infixExpression: String

    while (true)
    {
        print("\nВведите выражение, где символы разделенны символом пробела(или \"q\" чтобы выйти или\n \"test\" 'чтобы протестировать готовых на примерах) :")
        infixExpression = readLine()!!

        if (infixExpression == "q")
            break

        val calc:Calculator = CalculatorImpl()

        if(infixExpression == "test")
        {
            val samples = listOf<String>("5 - 1 - 1", "5.5 * 10 / ( 5 - 10 )", "4 + 2 * ( 5 - ( 2 - 1 ) )")

            samples.forEach {
                val result = calc.calculate(it)
                println("\n$it = $result \n")
            }


        }
        else{
            val result = calc.calculate(infixExpression)
            println("\nРезультат: $result \n")
        }


    }
}