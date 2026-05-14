package com.sante.priceindex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prices")
data class PriceEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val commodity: String,
    val modalPrice: String,
    val market: String,
    val district: String,
    val state: String,
    val arrivalDate: String,
    val timestamp: Long = System.currentTimeMillis()
)
