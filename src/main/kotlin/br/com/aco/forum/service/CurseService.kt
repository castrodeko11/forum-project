package br.com.aco.forum.service

import br.com.aco.forum.model.Curse
import org.springframework.stereotype.Service

@Service
class CurseService(
    private var curses: List<Curse> = ArrayList()
) {
    init {
        val curse = Curse(
            id = 1,
            name = "Kotlin",
            category = "Programming"
        )
        curses = curses.plus(curse)
    }

    fun findById(id: Long): Curse {
        return curses.stream().filter { it.id == id }.findFirst().get()
    }

}
