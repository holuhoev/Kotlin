package HW_2

/**
 * Объектно-ориентированный Hello World
 *
 * (устроить иерархию наследования,
 * в которой для разных наследников
 * печатаются разные сообщения).
 * */

interface SayHello
{
    fun hi();
}

open class Russian : SayHello
{
    override fun hi()
    {
        println("This is ${this.javaClass.simpleName} Привет!")
    }
}

class PoliteRussian : Russian()
{
    override fun hi()
    {
        println("This is ${this.javaClass.simpleName} Здравствуйте!")
    }
}

class InpoliteRussian : Russian()
{
    override fun hi()
    {
        println("This is ${this.javaClass.simpleName} Здарова");
    }
}

fun main(args: Array<String>)
{

    val greeds: MutableList<SayHello> = mutableListOf(Russian(), PoliteRussian(), InpoliteRussian());

    for (greed in greeds)
    {
        greed.hi();
    }
}