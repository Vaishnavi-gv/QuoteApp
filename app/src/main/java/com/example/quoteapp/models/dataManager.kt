package com.example.quoteapp.models

import android.content.Context
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfRenderer
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.Pages
import com.example.quoteapp.models.dataManager.currentPage
import com.example.quoteapp.models.dataManager.currentQuote
import com.google.gson.Gson
import java.io.InputStream

object dataManager {
    var data = emptyArray<Quote>()  //to access quotes

    var currentQuote: Quote? = null

    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)


    fun loadAssetFromFile(context: Context) {
        val inputStream = context.assets.open("Quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)   // creates new array of specified size
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }


    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}