package uz.gita.newsappxmlby.domain.useCase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article


interface TopHeadlines {
    suspend fun topHeadlines(): Flow<PagingData<Article>>
}