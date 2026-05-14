package com.sante.priceindex.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sante.priceindex.data.model.PriceRecord
import com.sante.priceindex.viewmodel.HomeUiState
import com.sante.priceindex.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onLogoutClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedCommodity by remember { mutableStateOf("Tomato") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sante Price Index") },
                actions = {
                    IconButton(onClick = { viewModel.fetchPrices() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                    IconButton(onClick = onLogoutClick) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (val state = uiState) {
                is HomeUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is HomeUiState.Error -> {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = state.message,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(onClick = { viewModel.fetchPrices() }) {
                            Text("Retry")
                        }
                    }
                }
                is HomeUiState.Success -> {
                    val commodities = state.prices.map { it.commodity }.distinct()
                    if (selectedCommodity !in commodities && commodities.isNotEmpty()) {
                        selectedCommodity = commodities.first()
                    }
                    
                    val filteredPrices = state.prices.filter { it.commodity == selectedCommodity }

                    Column(modifier = Modifier.fillMaxSize()) {
                        // Filter Chips
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(commodities) { commodity ->
                                FilterChip(
                                    selected = selectedCommodity == commodity,
                                    onClick = { selectedCommodity = commodity },
                                    label = { Text(commodity) }
                                )
                            }
                        }

                        // Graph
                        if (filteredPrices.isNotEmpty()) {
                            Text(
                                text = "$selectedCommodity Price Trend (Last 7 Days)",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                            PriceGraph(
                                records = filteredPrices,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(horizontal = 16.dp)
                            )
                        }

                        // List of Prices
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Reversed to show the most recent date at the top of the list
                            items(filteredPrices.reversed()) { priceRecord -> 
                                PriceCard(priceRecord)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PriceGraph(records: List<PriceRecord>, modifier: Modifier = Modifier) {
    if (records.isEmpty()) return
    
    val prices = records.mapNotNull { it.modalPrice.toFloatOrNull() }
    if (prices.isEmpty()) return
    
    val maxPrice = prices.maxOrNull() ?: 0f
    val minPrice = prices.minOrNull() ?: 0f
    
    // Add some padding to Y-axis range so line doesn't hit the absolute top/bottom
    val range = (maxPrice - minPrice).coerceAtLeast(1f)
    val graphMax = maxPrice + (range * 0.2f)
    val graphMin = (minPrice - (range * 0.2f)).coerceAtLeast(0f)
    val graphRange = graphMax - graphMin
    
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 2.dp
    ) {
        Canvas(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            val width = size.width
            val height = size.height
            val stepX = if (prices.size > 1) width / (prices.size - 1) else width
            
            val path = Path()
            val points = mutableListOf<Offset>()
            
            prices.forEachIndexed { index, price ->
                val x = index * stepX
                // Calculate y proportionally within the graphRange
                val normalizedY = 1f - ((price - graphMin) / graphRange)
                val y = normalizedY * height
                
                val point = Offset(x, y)
                points.add(point)
                
                if (index == 0) {
                    path.moveTo(x, y)
                } else {
                    path.lineTo(x, y)
                }
            }
            
            // Draw connecting line
            drawPath(
                path = path,
                color = primaryColor,
                style = Stroke(width = 4.dp.toPx())
            )
            
            // Draw points
            points.forEach { point ->
                drawCircle(
                    color = secondaryColor,
                    radius = 6.dp.toPx(),
                    center = point
                )
                drawCircle(
                    color = Color.White,
                    radius = 3.dp.toPx(),
                    center = point
                )
            }
        }
    }
}

@Composable
fun PriceCard(record: PriceRecord) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = record.commodity,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "₹${record.modalPrice}/kg",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Market: ${record.market}, ${record.district}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Date: ${record.arrivalDate}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
