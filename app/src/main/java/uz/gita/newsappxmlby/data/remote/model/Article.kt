package uz.gita.newsappxmlby.data.remote.model

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.parcelize.Parcelize
//import kotlinx.android.parcel.Parcelize


@Parcelize
data class Article(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    @Embedded val source: Source?,
    val title: String,
    val url: String,
    val urlToImage: String
): Parcelable