package com.example.contacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.contacts.databinding.ActivityAddContactBinding
import com.example.contacts.model.Contact
import com.example.contacts.viewmodel.ContactsViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddContactBinding.inflate(layoutInflater)
         setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSaveContact.setOnClickListener {
           validateAddContacts()

    }

    }
    fun validateAddContacts(){
        var name=binding.etName.toString()
        var email=binding.etEmail.toString()
        var phoneNumber=binding.etPhoneNumber.toString()
        var address=binding.etAddress.toString()
        var error=false

        if(name.isBlank()){
            binding.etName.error="Name is required"
            error=true
        }
        if(email.isBlank()){
            binding.etEmail.error="email is required"
            error=true
        }
        if(phoneNumber.isBlank()){
            binding.etPhoneNumber.error="phone number is required"
            error=true
        }
        if (address.isBlank()){
            binding.etAddress.error="Address is required"
            error=true
        }
        if(!error){
            val contact=Contact(contactId = 0,
                name=name,
                email = email,
                phoneNumber = phoneNumber,
                address = address,
                image = ""

            )

            contactsViewModel.saveContact(contact)
            finish()
        }



    }
}