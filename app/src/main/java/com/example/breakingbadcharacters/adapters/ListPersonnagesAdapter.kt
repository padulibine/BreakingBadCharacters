package com.example.breakingbadcharacters.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.breakingbadcharacters.R
import com.example.breakingbadcharacters.models.PersonnagesItem

class ListPersonnagesAdapter(private val personnages: MutableList<PersonnagesItem>):
    RecyclerView.Adapter<ListPersonnagesAdapter.PersoViewHolder>() {

    class PersoViewHolder(view: View): RecyclerView.ViewHolder(view){
        var nameView: TextView
        var birthdateView: TextView
        var imgView: ImageView

        init {
            nameView = view.findViewById<TextView>(R.id.list_personnage_name)
            birthdateView = view.findViewById<TextView>(R.id.list_personnage_birthdate)
            imgView = view.findViewById<ImageView>(R.id.list_personnage_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersoViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_personnages, parent, false)

        return PersoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersoViewHolder, position: Int) {

        val currentPersonnage = personnages.get(position)

        holder.nameView.text = currentPersonnage.name
        holder.birthdateView.text = currentPersonnage.birthday
        holder.imgView.load(currentPersonnage.img)

    }

    override fun getItemCount() = personnages.size
}