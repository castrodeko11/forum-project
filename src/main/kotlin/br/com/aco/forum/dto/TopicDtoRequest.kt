package br.com.aco.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicDtoRequest(
    @field:NotEmpty @Size(min = 5, max = 100, message = "Title must have between 5 and 100 characters")
    val title: String,
    @field:NotEmpty(message = "Message must not be empty")
    val message: String,
    @field:NotNull
    val curseId: Long,
    @field:NotNull
    val userId: Long
) {
    override fun toString(): String {
        return "TopicDto(title='$title', message='$message', curseId=$curseId, authorId=$userId)"
    }
}

