package uz.gita.newsappxmlby.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.newsappxmlby.data.repository.NewsRepository
import uz.gita.newsappxmlby.data.repository.impl.NewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun newsRepo(impl: NewsRepositoryImpl): NewsRepository
}