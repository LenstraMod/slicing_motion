package com.example.slicing_motion.ui.marketplace

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.slicing_motion.R

@Composable
fun ProductGridSection() {
    val products = listOf(
        Product("Paket Pipa NFT", "Rp 125.000", "Rp 150.000", R.drawable.a1m),
        Product("Paket Lengkap", "Rp 55.000", "Rp 75.000", R.drawable.a2m),
        Product("Paket Lengkap 2", "Rp 75.000", "Rp 80.000", R.drawable.a3m),
        Product("Sarung Tangan", "Rp 25.000", "Rp 50.000", R.drawable.orange)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(products) { product ->
            ProductItem(product)
        }
    }
}