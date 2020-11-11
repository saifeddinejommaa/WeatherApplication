package com.jommaa.datacomponent.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.jommaa.datacomponent.dataobject.Town
import io.reactivex.Single
import androidx.room.Query
import io.reactivex.Completable

@Dao
interface TownDao {
    @Query("SELECT * FROM town")
    fun getAll(): Single<List<Town>>

    @Query("SELECT * FROM town WHERE id=:townId")
    fun loadById(townId: Int): Single<List<Town>>

    @Query("SELECT count(*) from town")
    fun getTownsCount(): Int

    @Insert
    fun insert(vararg town: Town?): Completable

    @Delete
    fun delete(town: Town)
}