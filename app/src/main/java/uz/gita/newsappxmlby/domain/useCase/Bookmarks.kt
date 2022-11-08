package uz.gita.newsappxmlby.domain.useCase

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity


interface Bookmarks {
    suspend fun bookmarks():Flow<List<ArticleEntity>>
}