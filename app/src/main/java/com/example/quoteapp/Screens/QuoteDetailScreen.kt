package com.example.quoteapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quoteapp.models.Quote
import com.example.quoteapp.models.dataManager


@Composable
fun QuoteDetail(quote: Quote){

    BackHandler {           //to handle back button
        dataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier= Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0XFFffffff),
                        Color(0XFFE3E3E3)
                    )
                )
            )
    ){
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp) ,
            modifier= Modifier.padding()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier= Modifier
                    .padding(16.dp,24.dp)
            ) {
                Image(imageVector = Icons.Filled.FormatQuote ,
                    contentDescription ="Quote",
                    modifier= Modifier
                        .size(80.dp)
                        .rotate(180F))
                Text(
                    //text="Time is the most valuable thing a man can spend ",
                    text=quote.text,
                    style= MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    //text="Theophrastus",
                    text=quote.author,
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(1.dp))
            }
        }
    }
}