package com.example.apptavern.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_tavern")
data class Tavern (

    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int =0,
    val product: String,
    val quantity: String,
    val price: Int

)


