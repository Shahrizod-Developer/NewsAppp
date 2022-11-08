package uz.gita.newsappxmlby.domain.useCase

import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity

interface Check {
    suspend fun check(title:String): ArticleEntity?
}