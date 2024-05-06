package br.com.aco.forum.dto

import br.com.aco.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicDtoResponse(

    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val dateCreate : LocalDateTime
)
