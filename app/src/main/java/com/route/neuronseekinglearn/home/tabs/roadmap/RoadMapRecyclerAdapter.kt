package com.route.neuronseekinglearn.home.tabs.roadmap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.neuronseekinglearn.databinding.RoadMapItemBinding

class RoadMapRecyclerAdapter(private val tracksName: List<String>) :
    RecyclerView.Adapter<RoadMapRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = RoadMapItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.bottom1.text = tracksName[position]
        val trackName = tracksName[position]
       holder.viewBinding.bottom1.setOnClickListener{

           onTrackClickListeners.onItemClick(trackName)
       }
    }

    override fun getItemCount(): Int = tracksName.size

    lateinit var onTrackClickListeners: OnTrackClickListeners

    fun interface OnTrackClickListeners {
        fun onItemClick( trackName: String)
    }

    class ViewHolder(val viewBinding: RoadMapItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

}
