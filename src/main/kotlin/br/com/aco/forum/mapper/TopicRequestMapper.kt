package br.com.aco.forum.mapper

import br.com.aco.forum.dto.TopicDtoRequest
import br.com.aco.forum.model.Topic
import br.com.aco.forum.service.CurseService
import br.com.aco.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicRequestMapper(
    private val curseService: CurseService,
    private val userService: UserService

) : Mapper<TopicDtoRequest, Topic> {
    override fun map(t: TopicDtoRequest): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            curse = curseService.findById(t.curseId),
            author = userService.findById(t.userId)
        )
    }
}
