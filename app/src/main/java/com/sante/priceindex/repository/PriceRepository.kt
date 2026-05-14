package com.sante.priceindex.repository

import com.sante.priceindex.data.local.PriceDao
import com.sante.priceindex.data.local.PriceEntity
import com.sante.priceindex.data.model.PriceRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class PriceRepository(private val priceDao: PriceDao) {

    suspend fun getPricesForCommodities(commodities: List<String>): List<PriceRecord> {
        return withContext(Dispatchers.IO) {
            // Check if Room Database has data
            var cachedEntities = priceDao.getAllPrices()
            
            if (cachedEntities.isEmpty()) {
                val dummyData = mutableListOf<PriceEntity>()
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                
                // Generate historical data for the last 7 days
                for (i in 6 downTo 0) {
                    val cal = Calendar.getInstance()
                    cal.add(Calendar.DAY_OF_YEAR, -i)
                    val dateStr = dateFormat.format(cal.time)
                    // Ensure the timestamp increases slightly so they are sequential
                    val timestamp = cal.timeInMillis
                    
                    // Base prices with some realistic day-to-day fluctuation
                    val tomatoPrice = 40 + (Math.random() * 15).toInt()
                    val onionPrice = 25 + (Math.random() * 10).toInt()
                    val potatoPrice = 20 + (Math.random() * 8).toInt()
                    val carrotPrice = 50 + (Math.random() * 5).toInt()
                    val cabbagePrice = 20 + (Math.random() * 6).toInt()
                    
                    dummyData.add(PriceEntity(commodity = "Tomato", modalPrice = tomatoPrice.toString(), market = "Azadpur", district = "New Delhi", state = "Delhi", arrivalDate = dateStr, timestamp = timestamp))
                    dummyData.add(PriceEntity(commodity = "Onion", modalPrice = onionPrice.toString(), market = "Lasalgaon", district = "Nashik", state = "Maharashtra", arrivalDate = dateStr, timestamp = timestamp))
                    dummyData.add(PriceEntity(commodity = "Potato", modalPrice = potatoPrice.toString(), market = "Agra", district = "Agra", state = "Uttar Pradesh", arrivalDate = dateStr, timestamp = timestamp))
                    dummyData.add(PriceEntity(commodity = "Carrot", modalPrice = carrotPrice.toString(), market = "Ooty", district = "Nilgiris", state = "Tamil Nadu", arrivalDate = dateStr, timestamp = timestamp))
                    dummyData.add(PriceEntity(commodity = "Cabbage", modalPrice = cabbagePrice.toString(), market = "Kolar", district = "Kolar", state = "Karnataka", arrivalDate = dateStr, timestamp = timestamp))
                }
                
                priceDao.insertPrices(dummyData)
                cachedEntities = priceDao.getAllPrices()
            }

            // Filter if commodities list is provided and not empty
            val filteredEntities = if (commodities.isNotEmpty()) {
                cachedEntities.filter { it.commodity in commodities }
            } else {
                cachedEntities
            }
            
            // Sort chronologically (oldest first) so graph renders left-to-right correctly
            val sortedEntities = filteredEntities.sortedBy { it.timestamp }

            // Map PriceEntity to PriceRecord
            sortedEntities.map {
                PriceRecord(
                    state = it.state,
                    district = it.district,
                    market = it.market,
                    commodity = it.commodity,
                    variety = "Regular",
                    arrivalDate = it.arrivalDate,
                    minPrice = (it.modalPrice.toIntOrNull()?.minus(5))?.toString() ?: "0",
                    maxPrice = (it.modalPrice.toIntOrNull()?.plus(5))?.toString() ?: "0",
                    modalPrice = it.modalPrice
                )
            }
        }
    }
}
