package br.com.aco.forum.dto

import java.time.LocalDateTime

data class ErrorDtoResponse(
    val timeStamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
