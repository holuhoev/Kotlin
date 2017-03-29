
package kotlinathse


//TODO functions

//fun main(args: Array<String>) {
//    println(sum(1,2))
//    println(2 add 2)
//    println(2 largerThan 2)
//    println(2.add(4))
//    println(sumAll(1,2,3,4,5,6,7,8,9,10))
//}
//
//fun sum(x:Int, y:Int): Int {
//    return x + y
//}
//
//infix fun Int.add(x:Int): Int {
//    return this + x
//}
//
//infix fun Int.largerThan(x:Int): Boolean = this > x
//
//fun namedSum(theFirstArgument: Int = 0,
//             theSecondArgument: Int = 0): Int{
//    return theFirstArgument + theSecondArgument
//}
//
//fun printy(): Unit {
//    println("I'm fun")
//}
//
//fun sumAll(vararg x: Int): Int {
//    var result = 0
//    for(i in x){
//        result += i
//    }
//    return result
//}

//TODO higher-order functions and lambdas, collections

// (lambda) {x: Int, y: Int -> x + y}

//fun main(args: Array<String>) {
//    val arr = mutableListOf(1,2,3,4,5,7,2,3,5,6,7,2,45,6,6,7,7,0,345,6,6)
//
//    println(arr.forEach { print(it) })
//    println(arr.map { x:Int -> x*x }.filter { it > 10 }.map { it * 2 })
//    println(arr.max())
//
//    val multiplier = 100
//
//    var counter = 0
//
//    println(arr.map { it*multiplier })
//    println(arr.map { counter++
//        print("| $counter")
//        it })
//    println(counter)
//
//    val treeHeight = Tree::height
//    // = val treeHeight = {tree: Tree -> tree.height}
//    // trees.maxBy(Tree::height)
//
//    // fun funFun() = do_smth
//    // run (::funFun)
//}
//
//class Tree(age: Int){
//    val height = age*10
//}

//flatMap

//TODO

//fun main(args: Array<String>) {
//    val books = listOf(Book("Kotlin in Action", listOf("D Jemerov", "S Isakova")),
//            Book("Mort", listOf("Terry Pratchett")),
//            Book("War and Peace", listOf("Leo Tolstoy")))
//
//    println(books.flatMap { it.authors }.toSet())
//
//    val onlyStartsWithW = books.asSequence().filter { it.title.startsWith("W") }.toList()
//    println(onlyStartsWithW.map { it.title })
//
//    listOf(1, 2, 3, 4, 5, 6).asSequence()
//            .map { print("map($it)"); it * it }
//            .filter { print("filter($it)"); it % 2 == 0 }
//            .toList()
//
//    val natural = generateSequence(0) { it + 1 }
//    val numberFrom0to100 = natural.takeWhile { it <= 100 }
//    println(numberFrom0to100.last())
//
//    //with (object ){
//    // actions with object
//    //}
//
//    println(operationWithTwoArg(1,2,{x, y -> x + y}))
//    println(operationWithTwoArg(1,2))
//
//    println(strangeOper(10)(5))
//    println(strangeOper(10.1)(5))
//    //println(strangeOper("10")(5))
//
//    // anonymous func (return type)
//    // fun (x: Int, y: Int) : Int = x + y
//    // difference with lambda: return!!
//
////    fun lookForZero(people: List<Int>) {
////        people.forEach label@{
////            if (it == 0) return@label
////        }
////        println("Zero is here!")
////    }
//}
//
//class Book(val title: String, val authors: List<String>)
//
//fun operationWithTwoArg(x:Int, y:Int, operation: (Int,Int) -> Int = {x,y -> 0}): Int{
//    return operation(x,y)
//}
//
//fun strangeOper(x : Any) : (Int) -> Int{
//    return when(x){
//        is Int -> {n -> n * x}
//        is Double -> {n -> n* x.toInt()}
//        else -> {throw IllegalArgumentException("!!!")}
//    }
//}

// function type (Int, Int) -> Int

// .flatten() if there is no need in transformations

// sequences (lazy collection opers)

//TODO type system and operators

// nullable, null-safe, platform

// Int? = Int or null

//fun myStupidFun(x: Int): Boolean = x > 0
//
//fun main(args: Array<String>) {
//    println(myStupidFun(2))
//    //println(myStupidFun(null)) - ?
//    println(mySstupidFun(null))
//    println(mySsstupidFun(null))
//    println(mySsstupidFun("walking"))
//
//    println(myStrangeCast(5))
//    println(myStrangeCast("abc"))
//
//    val arr = arrayOf(1,2,3,null)
//    //println(arr.map(::ignoreNulls))
//    //println(arr.map { it?.let { ::ignoreNulls } })
//    //TODO how to?!
//
//}

//fun mySstupidFun(x: Int?): Boolean = if(x != null) x > 0 else false
//fun mySstupidFun(x: Int?): Boolean = if(x != null) x > 0 else throw NullPointerException()

//fun mySsstupidFun(s: String?): Boolean = if(s != null) s.endsWith("ing") else false

//fun mySsstupidFun(s: String?): Boolean? = s?.endsWith("ing")
// (Safe-call) obj?.fun() = if(obj != null) obj.fun() else null

//fun mySsstupidFun(s: String?): Boolean = s?.endsWith("ing") ?: false
// (Elvis) foo ?: bar = if(foo != null) foo else bar

// (Safe cast) obj as? Type = if(obj is Type) obj as Type else null
//fun myStrangeCast(x: Any): Int = x as? Int ?: 0

// (non-null assertion) obj!! = if (obj != null) obj else throw NullPointerException
//fun ignoreNulls(x : Int?){
//    val notNullInt: Int = x!!
//    println(notNullInt)
//}

// (let function) obj?.let{...} = if(obj != null) execute lambda else nothing happens

// Array<Int?>?