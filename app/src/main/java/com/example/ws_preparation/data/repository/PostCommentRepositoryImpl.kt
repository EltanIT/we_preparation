package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.repository.PostCommentRepository
import io.github.jan.supabase.postgrest.postgrest

class PostCommentRepositoryImpl: PostCommentRepository {
    override suspend fun postComment(comment: String, order_id: String, rating: Int) {
        val dataMap = mapOf(
            "comment" to comment,
            "rating" to rating.toString(),
            "order_id" to order_id,
        )
        client.postgrest["comments"].insert(dataMap)
    }
}