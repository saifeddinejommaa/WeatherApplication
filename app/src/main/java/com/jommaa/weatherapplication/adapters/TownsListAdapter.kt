package com.jommaa.weatherapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.jommaa.datacomponent.dataobject.Town
import com.jommaa.weatherapplication.databinding.ListItemTownBinding
import com.jommaa.weatherapplication.adapters.TownsListAdapter.Holder

class TownsListAdapter (restaurants: ObservableList<Town>) :
    ObservableRecyclerViewAdapter<Town, Holder>(restaurants) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ListItemTownBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClickListener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Holder(
        private val binding: ListItemTownBinding,
        private val onItemClickListener: ((item: Any) -> Unit)?) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var town: Town

        fun bind(town: Town) {
            this.town = town

            binding.name.text = town.name

            binding.root.setOnClickListener { onItemClickListener?.invoke(town) }
        }
    }
}
