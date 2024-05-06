package br.com.aco.forum.repository

import br.com.aco.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicsRepository: JpaRepository<Topic, Long> {
}