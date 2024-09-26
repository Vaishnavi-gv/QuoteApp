package com.example.quoteapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.Screens.QuoteDetail
import com.example.quoteapp.Screens.QuoteListScreen
import com.example.quoteapp.models.Quote
import com.example.quoteapp.models.dataManager
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            //delay(10000)
            dataManager.loadAssetFromFile(applicationContext)  //After activity load we tell data manager to load this load asset function (which read json file
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    if(dataManager.isDataLoaded.value){
        if(dataManager.currentPage.value==Pages.LISTING){
        QuoteListScreen(data =dataManager.data){
            dataManager.switchPages(it)
        }
        }
        else{
            dataManager.currentQuote?.let{QuoteDetail(quote = it)}
            

        }
    }
}
enum class Pages(){
    LISTING,
    DETAIL
}
