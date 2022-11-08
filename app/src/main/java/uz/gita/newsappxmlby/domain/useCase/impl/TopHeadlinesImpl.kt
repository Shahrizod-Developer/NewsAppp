package uz.gita.newsappxmlby.domain.useCase.impl

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.TopHeadlines
import javax.inject.Inject

class TopHeadlinesImpl @Inject constructor(
    private val repo: NewsRepository
): TopHeadlines {
    override suspend fun topHeadlines(): Flow<PagingData<Article>> {
        return repo.topHeadlines()
    }
}