package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactsRvAdapter(var contactList: List<Contact>):  //reference to entire
    RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
//        var itemView=LayoutInflater.from(parent.context)
//            .inflate(R.layout.contact_list_item,parent,false)
        var binding=ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var contactsViewHolder=ContactsViewHolder(binding)  //instance o f
        return contactsViewHolder
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {  //binds data to view
        var currentContact=contactList.get(position)
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvPhoneNumber.text=currentContact.phoneNumber //calls again for second item  //for one object
        holder.binding.tvEmail.text=currentContact.email
        holder.binding.tvAddress.text=currentContact.address
        Picasso.get()
            .load(currentContact.image)               //load image
            .placeholder(R.drawable.ic_baseline_person_24)   //show incase of being blank
            .error(R.drawable.ic_baseline_error_24)
            .resize(350,350) //
            .centerCrop()
//            .networkPolicy(Ne)
            .into(holder.binding.ivContactImage)  //display into
    }

    override fun getItemCount(): Int {
        return  contactList.size
    }
}
class ContactsViewHolder(var binding:ContactListItemBinding):
    RecyclerView.ViewHolder(binding.root){    //takes us to root of folder.
//        var tvName: TextView =itemView.findViewById<TextView>(R.id.tvName)
//        var tvPhoneNumber: TextView =itemView.findViewById<TextView>(R.id.tvPhoneNumber)
//        var tvEmail:TextView=itemView.findViewById<TextView>(R.id.tvEmail)
//        var tvAddress: TextView =itemView.findViewById<TextView>(R.id.tvAdderess)
//        var ivContactImage: ImageView =itemView.findViewById<ImageView>(R.id.ivContactImage)

//         var tvName=itemView.findViewById<TextView>(R.id.tvName)



}