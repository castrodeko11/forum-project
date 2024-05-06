package br.com.aco.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Response(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val dateCreate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne(fetch = FetchType.LAZY)
    val author: User,
    @ManyToOne(fetch = FetchType.LAZY)
    val topic: Topic,
    val solved: Boolean
) {

    override fun toString(): String {
        return "Response(id=$id, message='$message', dateCreate=$dateCreate, author=$author, Topico=$topic, solved=$solved)"
    }
}

