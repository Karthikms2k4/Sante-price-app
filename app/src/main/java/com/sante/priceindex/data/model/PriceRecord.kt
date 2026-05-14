package com.sante.priceindex.data.model

data class PriceRecord(
    val state: String,
    val district: String,
    val market: String,
    val commodity: String,
    val variety: String,
    val arrivalDate: String,
    val minPrice: String,
    val maxPrice: String,
    val modalPrice: String
)
