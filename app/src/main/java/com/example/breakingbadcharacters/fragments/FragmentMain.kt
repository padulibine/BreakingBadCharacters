package com.example.breakingbadcharacters.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadcharacters.API.BreakingBadAPI
import com.example.breakingbadcharacters.DAO.AppDatabase
import com.example.breakingbadcharacters.R
import com.example.breakingbadcharacters.adapters.ListPersonnagesAdapter
import com.example.breakingbadcharacters.models.PersonnagesItem


class FragmentMain : Fragment() {

    private lateinit var mLayoutManager: LinearLayoutManager
    private var mAdapter: ListPersonnagesAdapter? = null
    var mRecyclerView: RecyclerView ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById<RecyclerView>(R.id.fragment_main_list_characters)
        mLayoutManager = LinearLayoutManager(context)
        mRecyclerView?.layoutManager = mLayoutManager

        val api = BreakingBadAPI()
        api.setOnNetworkFinishListener(object: BreakingBadAPI.ListenerNetworkFinished{
            override fun getPersonnages(personnages: MutableList<PersonnagesItem>) {
                Log.i("marchepas", personnages.get(1).birthday)
                //faire ici un get de la base
                mAdapter = ListPersonnagesAdapter(personnages)
                mRecyclerView?.adapter = mAdapter

            }
        })
        api.startNetworkCall()
    }
}