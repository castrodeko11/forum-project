package br.com.aco.forum.controller

import br.com.aco.forum.dto.TopicDtoRequest
import br.com.aco.forum.dto.TopicDtoResponse
import br.com.aco.forum.dto.UpdateDtoRequest
import br.com.aco.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService
) {

    @GetMapping
    fun list(): List<TopicDtoResponse> {
        return topicService.list()

    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicDtoResponse {
        return topicService.findById(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid topicDto: TopicDtoRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicDtoResponse> {
        val topicDtoResponse = topicService.create(topicDto)
        val uri = uriBuilder.path("/topics/${topicDtoResponse.id}").build().toUri()

        return ResponseEntity.created(uri).body(topicDtoResponse)

    }

    @PutMapping
    fun update(@RequestBody @Valid updateTopicDto: UpdateDtoRequest): ResponseEntity<TopicDtoResponse> {
        val topicDtoResponse = topicService.update(updateTopicDto)

        return ResponseEntity.ok().body(topicDtoResponse)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        return topicService.delete(id)
    }
}