package net.radityalabs.alquran.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import net.radityalabs.alquran.R

class SurahViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var number: TextView = itemView.findViewById(R.id.number)
    var arabicName: TextView = itemView.findViewById(R.id.arabicName)
    var englishName: TextView = itemView.findViewById(R.id.englishName)
}