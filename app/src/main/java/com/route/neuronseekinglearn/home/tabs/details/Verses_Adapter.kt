package com.route.neuronseekinglearn.home.tabs.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.neuronseekinglearn.databinding.RoadMapItemBinding

class Verses_Adapter(val verses: List<String>) : RecyclerView.Adapter<Verses_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RoadMapItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.bottom1.text = verses[position]

    }

    override fun getItemCount(): Int = verses.size


    class ViewHolder(val binding: RoadMapItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}