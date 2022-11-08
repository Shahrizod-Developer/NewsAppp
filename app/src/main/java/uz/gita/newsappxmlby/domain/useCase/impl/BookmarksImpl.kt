package uz.gita.newsappxmlby.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.Bookmarks
import javax.inject.Inject

class BookmarksImpl @Inject constructor(
    private val repo:NewsRepository
): Bookmarks {
    override suspend fun bookmarks(): Flow<List<ArticleEntity>> {
        return repo.bookmarks()
    }
}