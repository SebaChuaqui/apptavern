package com.example.apptavern.DataBaseTavern

import android.text.Editable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "table_tavern")
data class Tavern(
    @PrimaryKey(autoGenerate = true)
                @NonNull
    var id: Int = 0,
    var product: String,
    var price: Int = 0,
    var quantity: Int = 0,

    )




