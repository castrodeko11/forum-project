package br.com.aco.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
