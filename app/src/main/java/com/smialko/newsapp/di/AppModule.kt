package com.smialko.newsapp.di

import android.app.Application
import androidx.room.Room
import com.smialko.newsapp.data.local.NewsDao
import com.smialko.newsapp.data.local.NewsDatabase
import com.smialko.newsapp.data.local.NewsTypeConvertor
import com.smialko.newsapp.data.manger.LocalUserMangerImpl
import com.smialko.newsapp.data.remote.NewsApi
import com.smialko.newsapp.data.repository.NewsRepositoryImpl
import com.smialko.newsapp.domain.manger.LocalUserManger
import com.smialko.newsapp.domain.repository.NewsRepository
import com.smialko.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.smialko.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.smialko.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.smialko.newsapp.domain.usecases.news.GetNews
import com.smialko.newsapp.domain.usecases.news.NewsUseCases
import com.smialko.newsapp.domain.usecases.news.SearchNews
import com.smialko.newsapp.util.Constants.BASE_URL
import com.smialko.newsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsData(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}