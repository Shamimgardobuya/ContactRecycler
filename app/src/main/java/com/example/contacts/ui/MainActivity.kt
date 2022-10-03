package com.example.contacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.model.Contact
import com.example.contacts.ContactsRvAdapter
import com.example.contacts.databinding.ActivityMainBinding
import com.example.contacts.viewmodel.ContactsViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel:ContactsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsViewModel.allContacts()

    }

    override fun onResume() {
        super.onResume()

        binding.FabAddContact.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }
        contactsViewModel.contactListLiveData.observe(this, Observer { allcontacts ->
            displayContacts(allcontacts)


        })
    }

    fun displayContacts(contact:List<Contact>) {
        var contactsAdapter = ContactsRvAdapter(contact)

        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactsAdapter
    }
}


