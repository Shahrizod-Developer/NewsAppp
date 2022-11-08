package uz.gita.newsappxmlby.presenter.viewModel

import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity
import uz.gita.newsappxmlby.domain.useCase.Bookmarks

interface ArticleViewModel {
    val isBookmarked: Flow<Boolean>

    fun bookmark(articleEntity: ArticleEntity)
    fun unBookmark(articleEntity: ArticleEntity)
    fun check(title: String)
}