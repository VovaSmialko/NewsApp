package com.smialko.newsapp.di

import android.app.Application
import com.smialko.newsapp.data.manger.LocalUserMangerImpl
import com.smialko.newsapp.domain.manger.LocalUserManger
import com.smialko.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.smialko.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.smialko.newsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}