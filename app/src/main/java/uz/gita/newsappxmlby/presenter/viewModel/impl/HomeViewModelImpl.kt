package uz.gita.newsappxmlby.presenter.viewModel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.domain.useCase.CategorizedHeadline
import uz.gita.newsappxmlby.domain.useCase.TopHeadlines
import uz.gita.newsappxmlby.presenter.screens.MainScreenDirections
import uz.gita.newsappxmlby.presenter.viewModel.HomeViewModel
import uz.gita.noteappplaymarketyb.navigation.Navigator
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    private val categorizedHeadlineUC: CategorizedHeadline,
    private val topHeadlinesUC: TopHeadlines,
    private val navigator: Navigator,
): HomeViewModel, ViewModel() {
    override val latest = MutableSharedFlow<PagingData<Article>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val topHeadlines = MutableSharedFlow<List<Article>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    init {
        viewModelScope.launch(IO) {
            topHeadlinesUC.topHeadlines().collectLatest {
                latest.emit(it)
            }
        }
    }

    override fun categorizedHeadlines(category: String) {
        viewModelScope.launch(IO) {
            categorizedHeadlineUC.categorizedHeadlines(category).collectLatest {
                topHeadlines.emit(it)
            }
        }
    }

    override fun articleScreen(article: Article) {
        viewModelScope.launch {
            navigator.navigateTo(MainScreenDirections.actionMainScreenToArticleScreen(article))
        }
    }
}