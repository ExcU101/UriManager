package com.excu_fcd.efm.di.module

import android.content.Context
import com.excu_fcd.core.provider.RemoteManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RemoteModule {

    @Provides
    fun provideManager(context: Context): RemoteManager = RemoteManager(context)

}