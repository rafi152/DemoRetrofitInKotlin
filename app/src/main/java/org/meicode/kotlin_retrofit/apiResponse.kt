package org.meicode.kotlin_retrofit

data class apiResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)