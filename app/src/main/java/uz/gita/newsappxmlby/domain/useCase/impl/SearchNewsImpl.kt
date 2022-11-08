package uz.gita.newsappxmlby.domain.useCase.impl

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.SearchNews
import javax.inject.Inject

class SearchNewsImpl @Inject constructor(
    private val repo:NewsRepository
): SearchNews {
    override suspend fun search(search: String): Flow<PagingData<Article>> {
        return repo.search(search)
    }
}