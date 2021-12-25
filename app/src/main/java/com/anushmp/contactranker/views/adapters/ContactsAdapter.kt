package com.anushmp.contactranker.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.anushmp.contactranker.R
import com.anushmp.contactranker.datamodels.local.ContactClass

class ContactsAdapter(val context:Context, val contactList:ArrayList<ContactClass>): RecyclerView.Adapter<ContactsAdapter.vh>() {

    inner class vh(view:View): RecyclerView.ViewHolder(view){

        val tvContactName:TextView = view.findViewById(R.id.itemViewContactName)
        val tvContactNumber:TextView = view.findViewById(R.id.itemViewContactNumber)
        val layout:ConstraintLayout = view.findViewById(R.id.itemLayoutConstraintLayout)

       fun setData(contactClass: ContactClass){
           tvContactName.text = contactClass.name
           tvContactNumber.text = contactClass.number

           layout.setOnClickListener {
               contactClass.rank++
               Toast.makeText(context,"rank is ${contactClass.rank}",Toast.LENGTH_SHORT).show()

               contactList.sortByDescending {
                   it.rank
               }

               notifyDataSetChanged()

           }

       }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        var view:View = LayoutInflater.from(context).inflate(R.layout.contacts_item_layout,parent,false)
        return vh(view)
    }

    override fun onBindViewHolder(holder: vh, position: Int) {
        holder.setData(contactList[position])


    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}