package br.com.aco.forum.service


import br.com.aco.forum.model.User
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class UserService (
    private var users: List<User> = ArrayList()
) {

    init {
        val user = User(
            id = 1,
            name = "André",
            email = "andre@forum.com")

        users = listOf(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter { it.id == id }.findFirst().get()
    }

}

