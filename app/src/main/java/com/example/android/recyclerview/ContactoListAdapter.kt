package com.example.android.recyclerview

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.contacto_list_item.view.*

class ContactoListAdapter(private val contactosList:ArrayList<Contacto>) : RecyclerView.Adapter<ContactoListAdapter.viewHolder>()
{
    override fun getItemCount(): Int {
        return contactosList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactoListAdapter.viewHolder {
    val layoutInflater = LayoutInflater.from(parent!!.context)
        return viewHolder(layoutInflater.inflate(R.layout.contacto_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: viewHolder?, position: Int) {
        holder!!.bind(contactosList[position])
    }


    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (contacto: Contacto){
            itemView.tvNombre.text = contacto.nombre
            itemView.tvTelefono.text = contacto.telefono
            itemView.setOnClickListener{
                Toast.makeText(it.context,"Elemento seleccionado:" + contacto.nombre,Toast.LENGTH_SHORT).show()

            }
        }
    }


}