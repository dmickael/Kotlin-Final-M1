package com.example.kotlinm1.di

import android.app.Application
import com.example.kotlinm1.di.AppModule
import com.example.kotlinm1.repository.MainRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }

    fun inject(mainRepository: MainRepository)
}