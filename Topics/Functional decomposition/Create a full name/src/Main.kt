// use this code as a source of inspiration for your function
fun getFullNames() {
    val firstName1 = readLine()
    val lastName1 = readLine()
    println(createFullName(firstName1, lastName1))
}

// implement your function here
fun createFullName(firstName: String?, lastName: String?): String {
    return String.format("%s %s", firstName, lastName)
}