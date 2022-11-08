package uz.gita.newsappxmlby.domain.useCase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.domain.useCase.Bookmarks
import uz.gita.newsappxmlby.domain.useCase.SearchBookmarks
import javax.inject.Inject

class SearchBookmarksImpl @Inject constructor(
    private val repo:NewsRepository
) : SearchBookmarks {
    override suspend fun searchBookmark(search: String): Flow<List<ArticleEntity>> {
        return repo.searchBookmarks(search)
    }
}