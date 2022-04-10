package com.example.breakingbadcharacters.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.breakingbadcharacters.API.BreakingBadAPI
import com.example.breakingbadcharacters.DAO.AppDatabase
import com.example.breakingbadcharacters.R
import com.example.breakingbadcharacters.adapters.ListPersonnagesAdapter
import com.example.breakingbadcharacters.models.PersonnagesItem
import com.example.breakingbadcharacters.DAO.PersonnagesItemDAO
import com.example.breakingbadcharacters.converters.*


class FragmentMain : Fragment() {

    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var personnagesItemDAO : PersonnagesItemDAO
    private lateinit var db: AppDatabase
    private var mAdapter: ListPersonnagesAdapter? = null
    private var mRecyclerView: RecyclerView ?= null
    private var personnagesDB: MutableList<PersonnagesItem> ?= null
    private var occupationConverter: OccupationConverter ?= null
    private var bcsAppearanceConverter: BcsAppearanceConverter ?= null
    private var appearanceConverter: AppearanceConverter?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById<RecyclerView>(R.id.fragment_main_list_characters)
        mLayoutManager = LinearLayoutManager(context)
        mRecyclerView?.layoutManager = mLayoutManager

        occupationConverter = OccupationConverter()
        bcsAppearanceConverter = BcsAppearanceConverter()
        appearanceConverter = AppearanceConverter()

        db = Room.databaseBuilder(
            activity?.applicationContext!!,
            AppDatabase::class.java, "breakingBad-database"
        )   .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .addTypeConverter(occupationConverter!!)
            .addTypeConverter(bcsAppearanceConverter!!)
            .addTypeConverter(appearanceConverter!!)
            .build()

        personnagesItemDAO = db.personnagesItemDAO()

        if (personnagesItemDAO.getAll().size == 0) {
            val api = BreakingBadAPI()
            api.setOnNetworkFinishListener(object : BreakingBadAPI.ListenerNetworkFinished {
                override fun getPersonnages(personnages: MutableList<PersonnagesItem>) {

                    personnages.forEach {
                        personnagesItemDAO.insertAll(it)
                    }

                    personnagesDB = personnagesItemDAO.getAll()
                    mAdapter = ListPersonnagesAdapter(personnagesDB!!)
                    mRecyclerView?.adapter = mAdapter
                }
            })
            api.startNetworkCall()
        }
        else{
            personnagesDB =  personnagesItemDAO.getAll()
            mAdapter = ListPersonnagesAdapter(personnagesDB!!)
            mRecyclerView?.adapter = mAdapter
        }



//// PERMET DE SUPPRIMER TOUS LES ELEMENTS DE LA BASE
//
//        personnagesDB?.forEach{
//            personnagesItemDAO.delete(it)
//        }

    }
}