package br.com.aco.forum.mapper

import br.com.aco.forum.dto.TopicDtoResponse
import br.com.aco.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper : Mapper<Topic, TopicDtoResponse> {

    override fun map(t: Topic): TopicDtoResponse {
        return TopicDtoResponse(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            dateCreate = t.dateCreate
        )
    }

}