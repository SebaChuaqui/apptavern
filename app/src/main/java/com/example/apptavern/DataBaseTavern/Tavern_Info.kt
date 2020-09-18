package com.example.apptavern.DataBaseTavern

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_info")
data class Tavern_Info(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int =0,
    val boleta: String,
    val total:Int
)