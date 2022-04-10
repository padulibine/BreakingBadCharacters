package com.example.breakingbadcharacters.API

import com.example.breakingbadcharacters.models.PersonnagesItem
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BreakingBadAPI {

    private lateinit var mListener: ListenerNetworkFinished

    interface ListenerNetworkFinished{
        fun getPersonnages(personnages: MutableList<PersonnagesItem>)
    }

    fun setOnNetworkFinishListener(listener: ListenerNetworkFinished){
        mListener = listener
    }

    val client = HttpClient(CIO){
        install(JsonFeature) {
            serializer = GsonSerializer() {
                setPrettyPrinting()
                disableHtmlEscaping()
            }
        }
    }

    public fun startNetworkCall(){

        CoroutineScope(Dispatchers.IO).launch {
            val personnages: MutableList<PersonnagesItem> = client.get("https://www.breakingbadapi.com/api/characters")
            withContext(Dispatchers.Main) {
                mListener.getPersonnages(personnages as MutableList<PersonnagesItem>)
            }
        }
    }


}

