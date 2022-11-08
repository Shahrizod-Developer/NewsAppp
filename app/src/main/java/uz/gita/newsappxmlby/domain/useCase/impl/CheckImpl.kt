package uz.gita.newsappxmlby.domain.useCase.impl

import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.Check
import javax.inject.Inject

class CheckImpl @Inject constructor(
    private val repo: NewsRepository
) : Check {
    override suspend fun check(title: String): ArticleEntity? {
        return repo.check(title)
    }
}