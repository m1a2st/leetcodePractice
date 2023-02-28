package kt

class Test {

}

var s: Int = 4;
fun sa() {
    s += 1
}

var list = listOf("a", "b", "c")

fun main(args: Array<String>) {


    list.filter { it == "a" }
        .forEach{println(it)};
}



fun sum(a: Int, b: Int) = a + b;