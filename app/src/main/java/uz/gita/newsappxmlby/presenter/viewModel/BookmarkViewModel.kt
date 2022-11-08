package uz.gita.newsappxmlby.presenter.viewModel

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity
import uz.gita.newsappxmlby.data.remote.model.Article

interface BookmarkViewModel {
    val searchFlow: Flow<List<ArticleEntity>>
    val bookmarks:Flow<List<ArticleEntity>>
    fun searchBookmark(search:String)

}