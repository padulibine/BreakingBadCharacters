package com.example.breakingbadcharacters

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.breakingbadcharacters.DAO.AppDatabase
import com.example.breakingbadcharacters.DAO.PersonnagesItemDAO
import com.example.breakingbadcharacters.models.PersonnagesItem
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity()  {

    private lateinit var db: AppDatabase
    var personnagesItemDAO : PersonnagesItemDAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()


      /*  CoroutineScope(Dispatchers.IO).launch {
            personnagesItemDAO!!.insertAll(PersonnagesItem( 1, "test", "23-07-2001", "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg" ))

            val personnages =  personnagesItemDAO!!.getAll()
            withContext(Dispatchers.Main) {
                println("test test")
                println(personnages)
            }
        }*/
    }

    fun getDB(): AppDatabase? {
        return this.db
    }


}