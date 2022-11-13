package com.example.myapplication.utils

import android.content.Context
import io.appwrite.*
import io.appwrite.services.*
import io.appwrite.exceptions.AppwriteException

import io.appwrite.extensions.toJson
import io.appwrite.models.*

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

object getEvents {
    private val endpoint = "http://localhost/v1"
    private val projectId = "636fe09891dddc32a9cc"
    private var databaseId = "636ffe3e9518ab929314"
    private val collectionId = "636ffe509edfa569df83"

    private lateinit var client: Client
    private lateinit var databases: Databases

    private val _dialogText = MutableLiveData<String?>(null)
    val dialogText: LiveData<String?> = _dialogText

    fun createClient(context: Context) {
        client = Client(context)
            .setEndpoint(endpoint)
            .setProject(projectId)
            .setSelfSigned(true)

        databases = Databases(client)
    }

    @Composable
    fun getEventsAtHall(hall: String) : () -> Unit {
        val composableScope = rememberCoroutineScope()
        composableScope.launch {
            val documentList: DocumentList = databases.listDocuments(
                databaseId,
                collectionId,
                queries = listOf(
                    Query.equal("location", hall)
                )
            )
            val json = documentList.toJson()
            _dialogText.postValue(json)
        }
    }


//    fun getEvents(hall: String){
//        val response = databaseService.getCollection(
//            databaseId = "636ffe3e9518ab929314",
//            collectionId = "636ffe509edfa569df83"
//        )
//        val json = response.body?.string()
//    }
}