package br.com.aco.forum.repository

import br.com.aco.forum.model.Curse
import org.springframework.data.jpa.repository.JpaRepository

interface CurseRepository: JpaRepository<Curse, Long> {
}