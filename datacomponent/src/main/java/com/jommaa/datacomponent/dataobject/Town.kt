package com.jommaa.datacomponent.dataobject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "town")
data class Town (
    @ColumnInfo(name = "town_name") var name: String,
    @ColumnInfo(name = "lat") var lat: Double,
    @ColumnInfo(name = "lon") var lon: Double){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int = 0

}