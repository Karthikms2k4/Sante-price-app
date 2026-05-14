package com.sante.priceindex.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sante.priceindex.data.local.AppDatabase
import com.sante.priceindex.data.model.PriceRecord
import com.sante.priceindex.repository.PriceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val prices: List<PriceRecord>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PriceRepository

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        val database = AppDatabase.getDatabase(application)
        repository = PriceRepository(database.priceDao())
        fetchPrices()
    }

    fun fetchPrices() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            try {
                // Fetching for Tomato, Onion, Potato as per Phase 2 & 3 requirements
                val commodities = listOf("Tomato", "Onion", "Potato")
                val results = repository.getPricesForCommodities(commodities)
                
                if (results.isEmpty()) {
                    _uiState.value = HomeUiState.Error("No data found or API Key is missing.")
                } else {
                    _uiState.value = HomeUiState.Success(results)
                }
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}
