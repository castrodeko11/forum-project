package br.com.aco.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateCreate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val curse: Curse,

    @ManyToOne
    val author: User,

    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NotAnswered,

    @OneToMany(mappedBy = "topic", cascade = [CascadeType.ALL])
    val responses: List<Response> = ArrayList()
)