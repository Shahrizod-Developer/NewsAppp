package uz.gita.newsappxmlby.domain.useCase

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity

interface SearchBookmarks {
    suspend fun searchBookmark(search:String):Flow<List<ArticleEntity>>
}