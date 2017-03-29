package HW_2

/**
 * Спроектировать и реализовать класс
 * с данным «Книжный шкаф».
 * Шкаф содержит в себе полки,
 * на которых могут размещаться книги.
 *
 * Свойства шкафа:
 * конфигурация полок,
 * свойства полок: размеры, количество помещаемых книг.
 * */



class BookCase(val shelves: MutableList<BookShelf>)
{
    val numberOfShelves = shelves.size

    fun capacity(): Int
    {
        var summ: Int = 0
        for (shelf in shelves)
            summ += shelf.capacity

        return summ
    }

    fun small() : Int
    {
        var res = 0;

        for (shelf in shelves)
            if(shelf is SmallShelf)
                res++

        return res
    }

    fun long() : Int
    {
        var res = 0;

        for (shelf in shelves)
            if(shelf is LongShelf)
                res++

        return res
    }

    fun medium() : Int
    {
        var res = 0;

        for (shelf in shelves)
            if(shelf is MediumShelf)
                res++

        return res
    }

    fun printInfo()
    {
        var info:String  = "Shelves: $numberOfShelves\n" +
                            "Capacity: ${capacity()}\n" +
                            "Small: ${small()}\n" +
                            "Medium: ${medium()}\n" +
                            "Long: ${long()}\n\n"
        print(info);

        for(shelf in shelves)
            print(shelf)
    }

}

interface BookShelf
{
    val capacity: Int
        get() = 10

    val width: Double
        get() = 30.0

    val height: Double
        get() = 20.0

    val length: Double
        get() = 70.0

    override fun toString(): String;
}

class SmallShelf() : BookShelf
{
    override val capacity: Int
        get() = 5

    override val length: Double
        get() = 35.0

    override fun toString(): String
    {
        return "Shelf: ${this.javaClass.simpleName}\n" +
                "Width: $width\n" +
                "Height: $height\n" +
                "Length: $length\nCapacity: $capacity\n\n"
    }
}

class MediumShelf() : BookShelf
{
    override fun toString(): String
    {
        return "Shelf: ${this.javaClass.simpleName}\n" +
                "Width: $width\n" +
                "Height: $height\n" +
                "Length: $length\nCapacity: $capacity\n\n"
    }
}

class LongShelf() : BookShelf
{
    override val capacity: Int
        get() = 20

    override val length: Double
        get() = 140.0

    override fun toString(): String
    {
        return "Shelf: ${this.javaClass.simpleName}\n" +
                "Width: $width\n" +
                "Height: $height\n" +
                "Length: $length\nCapacity: $capacity\n\n"
    }
}

fun main(args: Array<String>)
{
    val shelves = mutableListOf(MediumShelf(), SmallShelf(), MediumShelf(), LongShelf())

    val shkaf = BookCase(shelves)

    shkaf.printInfo()
}