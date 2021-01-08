package de.mayflower

class ResponseHelper {
    fun allUsers() :Map<String, List<String>> {
        val users :List<String> = listOf(
            "John Doe", "Jane Doe", "Peter Fox", "Adam Smith",
            "Laurence Walker", "DefJam Haskell", "Fritz Pearson",
            "Christopher Stock"
        )

        return mapOf("users" to users)
    }
}
