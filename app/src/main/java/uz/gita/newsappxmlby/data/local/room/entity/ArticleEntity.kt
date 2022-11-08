package uz.gita.newsappxmlby.data.local.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.newsappxmlby.data.remote.model.Article

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val articleId: Int,
    @Embedded val article: Article
)
