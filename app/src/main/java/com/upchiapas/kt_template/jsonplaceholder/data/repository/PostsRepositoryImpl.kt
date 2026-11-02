package com.upchiapas.kt_template.jsonplaceholder.data.repository

import com.upchiapas.kt_template.jsonplaceholder.data.datasource.PostsRemoteDataSource
import com.upchiapas.kt_template.jsonplaceholder.data.dto.CreatePostDto
import com.upchiapas.kt_template.jsonplaceholder.data.mapper.toDomain
import com.upchiapas.kt_template.jsonplaceholder.data.mapper.toDomainList
import com.upchiapas.kt_template.jsonplaceholder.data.model.Post

class PostsRepositoryImpl(
    private val remoteDataSource: PostsRemoteDataSource
) : PostsRepository {

    override suspend fun getPosts(): Result<List<Post>> {
        return runCatching {
            val postDtos = remoteDataSource.getPosts()
            postDtos.toDomainList()
        }
    }

    override suspend fun createPost(title: String, body: String): Result<Post> {
        return runCatching {
            val createDto = CreatePostDto(userId = 1, title = title, body = body)
            val createdDto = remoteDataSource.createPost(createDto)
            createdDto.toDomain()
        }
    }
}
