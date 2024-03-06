package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.ProfileData

interface PostCommentRepository {

        suspend fun postComment(comment: String, order_id: String,  rating: Int)
}