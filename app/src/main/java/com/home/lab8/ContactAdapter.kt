package com.home.lab8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (private val contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tv_name = view.findViewById<TextView>(R.id.tv_name)
        val tv_phone = view.findViewById<TextView>(R.id.tv_phone)
        val img_delete = view.findViewById<ImageView>(R.id.img_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = contacts[position].name
        holder.tv_phone.text = contacts[position].phone
        holder.img_delete.setOnClickListener {
            contacts.removeAt(position)
            notifyDataSetChanged()
        }
    }
}