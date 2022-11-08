package uz.gita.newsappxmlby.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.CategorizedHeadline
import javax.inject.Inject

class CategorizedHeadlineImpl @Inject constructor(
    private val repo:NewsRepository
): CategorizedHeadline {
    override suspend fun categorizedHeadlines(category: String): Flow<List<Article>> {
        return repo.categorizedHeadlines(category)
    }
}