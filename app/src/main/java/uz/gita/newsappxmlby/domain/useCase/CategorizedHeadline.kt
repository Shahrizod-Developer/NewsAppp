package uz.gita.newsappxmlby.domain.useCase

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article

interface CategorizedHeadline {
    suspend fun categorizedHeadlines(category: String): Flow<List<Article>>
}