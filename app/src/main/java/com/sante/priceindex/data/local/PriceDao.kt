package com.sante.priceindex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PriceDao {
    @Query("SELECT * FROM prices ORDER BY timestamp DESC")
    suspend fun getAllPrices(): List<PriceEntity>

    @Query("SELECT * FROM prices WHERE commodity = :commodity ORDER BY timestamp DESC")
    suspend fun getPricesByCommodity(commodity: String): List<PriceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrices(prices: List<PriceEntity>)

    @Query("DELETE FROM prices")
    suspend fun clearAll()
}
