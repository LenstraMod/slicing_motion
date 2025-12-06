package com.example.slicing_motion.ui.marketplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(device = "spec:width=1080px,height=2340px,dpi=440")
fun MarketplaceScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color(0xFF093731), shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            MarketplaceHeader()
            SearchBarSection()
            CategoryFilterSection()
            Spacer(modifier = Modifier.height(24.dp))
            ProductGridSection()
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF5F5F5)), // Placeholder bg
                contentAlignment = Alignment.Center
            ) {
                 Image(
                     painter = painterResource(id = product.imageRes),
                     contentDescription = product.name,
                     modifier = Modifier.fillMaxSize(),
                     contentScale = ContentScale.Crop
                 )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text(
                text = "Starter Kit",
                fontSize = 10.sp,
                color = Color.Gray
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = product.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 2
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF139779)
                )
                
                Spacer(modifier = Modifier.width(6.dp))
                
                Text(
                    text = product.oldPrice,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                )
            }
        }
    }
}
