package com.route.neuronseekinglearn.home.tabs.roadmap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.neuronseekinglearn.databinding.RoadMapItemBinding

class RoadMapRecyclerAdapter(val Names: List<String>) :
    RecyclerView.Adapter<RoadMapRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = RoadMapItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ViewBinding.bottom1.text = Names[position]
    }

    override fun getItemCount(): Int = Names.size

    class ViewHolder(val ViewBinding: RoadMapItemBinding) :
        RecyclerView.ViewHolder(ViewBinding.root)

}
