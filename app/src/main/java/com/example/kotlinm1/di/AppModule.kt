package com.example.kotlinm1.di

import android.app.Application
import android.content.Context
import com.example.kotlinm1.adapter.MemosHelper
import com.example.kotlinm1.entity.MemoDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context {

        return application

    }

    @Singleton
    @Provides
    fun provideNoteDAO(applicationContext: Context): MemoDAO {

        return MemosHelper.getDatabase(applicationContext).noteDAO()

    }
}