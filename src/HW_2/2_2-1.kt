package HW_2

/**
 * Спроектировать и реализовать класс с данным «Книга».
 * Класс должен уметь хранить библиографическую информацию:
 * Название, имя автора (м.б. несколько), издательство, год издания, город,
 * количество страниц, тип бумаги, тип обложки, ISBN, формат.
 *
 * Книги могут отличаться по жанру, тематике.
 * */

open class Book(val name: String,
                val publisher: String,
                val year: Int,
                val city: String,
                val numberOfPapers: Int,
                val authors: MutableSet<String>)
{

}

class HorrorBooks(name: String,
                  publisher: String,
                  year: Int,
                  city: String,
                  numberOfPapers: Int,
                  authors: MutableSet<String>) : Book(name,publisher,year,city,numberOfPapers,authors)
{

}

class FunnyBooks(name: String,
                  publisher: String,
                  year: Int,
                  city: String,
                  numberOfPapers: Int,
                  authors: MutableSet<String>) : Book(name,publisher,year,city,numberOfPapers,authors)
{

}

class NovelBooks(name: String,
                  publisher: String,
                  year: Int,
                  city: String,
                  numberOfPapers: Int,
                  authors: MutableSet<String>) : Book(name,publisher,year,city,numberOfPapers,authors)
{

}

fun main(args:Array<String>)
{

}