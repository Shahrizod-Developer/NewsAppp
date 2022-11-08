package uz.gita.newsappxmlby.domain.useCase.impl

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.LatestNews
import javax.inject.Inject

class LatestNewsImpl @Inject constructor(
    private val repo: NewsRepository
) : LatestNews {
    override suspend fun latestNews(): Flow<PagingData<Article>> {
        return repo.latestNews()
    }
}