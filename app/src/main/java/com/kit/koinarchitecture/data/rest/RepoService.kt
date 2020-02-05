package com.kit.koinarchitecture.data.rest

import com.kit.koinarchitecture.data.model.Posts
import io.reactivex.Single
import retrofit2.http.GET

interface RepoService {
    @GET("posts")
    suspend fun getRepositories(): List<Posts>
}