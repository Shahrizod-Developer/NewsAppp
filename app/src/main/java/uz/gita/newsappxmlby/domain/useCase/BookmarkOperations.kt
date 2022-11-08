package uz.gita.newsappxmlby.domain.useCase

import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity

interface BookmarkOperations {
    suspend fun bookmark(articleEntity: ArticleEntity)
    suspend fun unBookmark(articleEntity: ArticleEntity)
}