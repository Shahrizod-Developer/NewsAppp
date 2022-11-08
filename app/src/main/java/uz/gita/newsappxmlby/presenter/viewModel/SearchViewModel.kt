package uz.gita.newsappxmlby.presenter.viewModel

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.data.remote.model.BaseModel

interface SearchViewModel {
    val searchFlow: Flow<PagingData<Article>>
    fun searchNews(search:String)
}