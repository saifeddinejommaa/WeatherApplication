package com.jommaa.weatherapplication.di
import com.jommaa.datacomponent.db.datasource.TownDataSource
import com.jommaa.datacomponent.db.repositories.TownRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TownRepositoryModule {
    @Provides
    @Singleton
    fun provideTownRepository(townDataSource:TownDataSource): TownRepository {
        return TownRepository(townDataSource)
    }
}