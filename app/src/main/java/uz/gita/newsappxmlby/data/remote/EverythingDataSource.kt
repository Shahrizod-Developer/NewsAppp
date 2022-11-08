package uz.gita.newsappxmlby.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import uz.gita.newsappxmlby.data.remote.model.Article
import uz.gita.newsappxmlby.utils.PAGE_SIZE
import java.io.IOException

class EverythingDataSource(
    private val newsApi: NewsApi,
    private val query: String
) : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val currentPageNumber = params.key ?: 1
        val response = newsApi.everything(
            search = query,
            pageSize = PAGE_SIZE,
            pageCount = currentPageNumber
        )

        if (response.isSuccessful) {
            Log.d("zzzz","${response.isSuccessful}")
            Log.d("zzzz","${response.body()!!.totalResults} + @$query")
        } else {
            Log.d("zzzz","${response.isSuccessful}")
        }
        return try {
            LoadResult.Page(
                data = response.body()!!.articles,
                prevKey = if (currentPageNumber > 1) currentPageNumber - 1 else null,
                nextKey = if (currentPageNumber < response.body()!!.totalResults / PAGE_SIZE) currentPageNumber + 1 else null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}