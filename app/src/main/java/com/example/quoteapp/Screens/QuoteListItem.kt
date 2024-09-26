package com.example.quoteapp.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quoteapp.models.Quote

@Composable
fun QuoteListItem(quote:Quote, onClick: (quote:Quote)-> Unit){

    Card(
         elevation = CardDefaults.cardElevation(
             defaultElevation = 4.dp),
         modifier=Modifier
             .clickable { onClick(quote) }
             .padding(8.dp)
    ){
        Row(
            modifier=Modifier.padding(16.dp)
        ){
            Image(imageVector = Icons.Filled.FormatQuote ,
                contentDescription = "Quote",
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier= Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180F)
            )
            Spacer(modifier = Modifier.padding(4.dp))

            Column (modifier=Modifier.weight(1F)){
                //Text(text = "Time is the most valuable thing a man can spend",
                Text(text=quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier=Modifier.padding(0.dp,0.dp,0.dp,8.dp)
                    )
                Box(modifier = Modifier
                    .background(Color(0XFFEEEEEE))
                    .fillMaxWidth(.4F)
                    .height(1.dp))
                Text(
                    //text="Theophrastus",
                    text= quote.author,
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top=4.dp)
                )
            }
        }
    }
}
