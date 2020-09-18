package com.example.apptavern.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_info")
data class TavernInfo (

    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int =0,
    val info:String,
    val total:Int

)