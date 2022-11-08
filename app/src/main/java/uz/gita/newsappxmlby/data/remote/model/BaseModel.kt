package uz.gita.newsappxmlby.data.remote.model

import uz.gita.newsappxmlby.data.remote.model.Article

data class BaseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)