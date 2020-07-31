package com.jommaa.datacomponent.db.repositories

import com.jommaa.datacomponent.Results.TownsListResult
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.datasource.TownDataSource
import io.reactivex.Observable
import java.util.*

class TownRepository(private val dataSource: TownDataSource) {
     fun insertTown(town: Town?) = dataSource.insertTown(town)

    fun getAllTowns() : Observable<TownsListResult> {
       return  dataSource.getAllTowns().toObservable()
            .map { TownsListResult.Success(it) as TownsListResult }
            .onErrorReturn { TownsListResult.Failure(it) }
            .startWith(TownsListResult.Loading)
    }
}