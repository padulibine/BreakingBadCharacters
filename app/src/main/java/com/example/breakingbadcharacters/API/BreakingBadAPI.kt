package com.example.breakingbadcharacters.API

import android.util.Log
import androidx.room.Room
import com.example.breakingbadcharacters.DAO.AppDatabase
import com.example.breakingbadcharacters.DAO.PersonnagesItemDAO
import com.example.breakingbadcharacters.MainActivity
import com.example.breakingbadcharacters.models.Personnages
import com.example.breakingbadcharacters.models.PersonnagesItem
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.security.AccessController.getContext

class BreakingBadAPI {

    private lateinit var mListener: ListenerNetworkFinished
    lateinit var personnagesItemDAO : PersonnagesItemDAO



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

        var db = MainActivity().getDB()
        personnagesItemDAO = db!!.personnagesItemDAO()

        CoroutineScope(Dispatchers.IO).launch {
            personnagesItemDAO!!.insertAll(PersonnagesItem( 1, "test", "23-07-2001", "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg" ))
            val personnages =  personnagesItemDAO!!.getAll()

            //val personnages: MutableList<PersonnagesItem> = client.get("https://www.breakingbadapi.com/api/characters")
            //faire un insert dans la base ici

            withContext(Dispatchers.Main) {
                mListener.getPersonnages(personnages as MutableList<PersonnagesItem>)
            }
        }
    }


}

