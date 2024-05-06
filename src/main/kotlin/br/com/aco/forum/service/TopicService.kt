package br.com.aco.forum.service

import br.com.aco.forum.dto.TopicDtoRequest
import br.com.aco.forum.dto.TopicDtoResponse
import br.com.aco.forum.dto.UpdateDtoRequest
import br.com.aco.forum.exception.NotFoundException
import br.com.aco.forum.mapper.TopicRequestMapper
import br.com.aco.forum.mapper.TopicResponseMapper
import br.com.aco.forum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicResponseMapper: TopicResponseMapper,
    private val topicRequestMapper: TopicRequestMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(): List<TopicDtoResponse> {
        return topics.stream().map { t -> topicResponseMapper.map(t) }.toList()
    }


    fun findById(id: Long): TopicDtoResponse {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        return TopicDtoResponse(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            dateCreate = topic.dateCreate
        )
    }

    fun create(topicDto: TopicDtoRequest): TopicDtoResponse {
        val topic = topicRequestMapper.map(topicDto)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus((topic))

        return TopicResponseMapper().map(topic)
    }

    fun update(updateTopicDto: UpdateDtoRequest): TopicDtoResponse {
        val topic = topics.stream().filter { t -> t.id == updateTopicDto.id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        val updateTopic = Topic(
            id = updateTopicDto.id,
            title = updateTopicDto.title,
            message = updateTopicDto.message,
            author = topic.author,
            curse = topic.curse,
            responses = topic.responses,
            status = topic.status,
            dateCreate = topic.dateCreate
        )
        topics = topics.minus(topic).plus(
            updateTopic
        )

        return TopicResponseMapper().map(updateTopic)
    }

    fun delete(id: Long) {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        topics = topics.minus(topic)
    }
}