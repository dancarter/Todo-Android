package com.vmware.tokyo.todo.application

import android.app.Application
import com.vmware.tokyo.todo.BuildConfig
import com.vmware.tokyo.todo.components.http.retrofitModule
import com.vmware.tokyo.todo.components.todo.todoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TodoApplication)

            properties(
                mapOf(
                    "serverBaseURL" to BuildConfig.SERVER_BASE_URL
                )
            )
            modules(
                todoModule,
                retrofitModule
            )
        }
    }
}