package com.example.contacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ContactListItemBinding
import com.example.contacts.model.Contact
import com.example.contacts.ui.viewContactActivity

class ContactsRvAdapter(var contactList: List<Contact>):  //reference to entire
    RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
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
//        Picasso.get()
//            .load(currentContact.image)                  //load image
//            .placeholder(R.drawable.ic_baseline_person_24)   //show incase of being blank
//            .error(R.drawable.ic_baseline_error_24)
//            .resize(350,350) //
////            .centerCrop()
////            .networkPolicy(Ne)
//            .into(holder.binding.imgContactImage)
            val context=holder.itemView.context
        holder.binding.cvContact.setOnClickListener {
            val intent=Intent(context, viewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("PHONENUMBER",currentContact.phoneNumber)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)






        }


    }

    override fun getItemCount(): Int {
        return  contactList.size

    }


}
class ContactsViewHolder(var binding:ContactListItemBinding):
    RecyclerView.ViewHolder(binding.root){




}