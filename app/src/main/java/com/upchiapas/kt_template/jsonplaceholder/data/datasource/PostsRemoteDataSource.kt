package com.upchiapas.kt_template.jsonplaceholder.data.datasource

import com.upchiapas.kt_template.jsonplaceholder.data.dto.CreatePostDto
import com.upchiapas.kt_template.jsonplaceholder.data.dto.PostDto

class PostsRemoteDataSource(
    private val apiService: PostsApiService
) {

    suspend fun getPosts(): List<PostDto> {
        val response = apiService.getPosts()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw Exception("Error de servidor: ${response.code()} ${response.message()}")
        }
    }

    suspend fun createPost(createPostDto: CreatePostDto): PostDto {
        val response = apiService.createPost(createPostDto)
        val body = response.body()
        if (response.isSuccessful && body != null) {
            return body
        } else {
            throw Exception("Error al crear la publicación: ${response.code()} ${response.message()}")
        }
    }
}
