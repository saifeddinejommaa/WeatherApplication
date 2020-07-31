package com.jommaa.datacomponent.db.datasource

import android.app.Application
import android.content.Context
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.datacomponent.db.AppDatabase
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class  TownDataSource(val context:Application) {
    val dataBase=AppDatabase.invoke(context)

    fun insertTown(town: Town?) : Completable{
       return dataBase.TownDao().insert(town)
    }

    fun getAllTowns():Single<List<Town>>{
      return  dataBase.TownDao().getAll()
    }


}