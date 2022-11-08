package uz.gita.newsappxmlby.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.gita.newsappxmlby.data.remote.model.BaseModel
import uz.gita.newsappxmlby.utils.API_KEY
import uz.gita.newsappxmlby.utils.PAGE_SIZE

interface NewsApi {
    @GET("everything")
    suspend fun everything(
        @Query("q") search: String = "android",
        @Query("searchIn") searchIn: String = "title",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = PAGE_SIZE,
        @Query("page") pageCount: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<BaseModel>

    @GET("top-headlines")
    suspend fun topHeadlines(
        @Query("country") country: String? = "us",
        @Query("category") category: String? = "business",
        @Query("pageSize") pageSize: Int = PAGE_SIZE,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<BaseModel>

}