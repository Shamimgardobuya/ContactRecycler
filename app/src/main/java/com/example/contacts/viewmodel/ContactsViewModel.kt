package com.example.contacts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.model.Contact
import com.example.contacts.repository.ContactsRepository
import kotlinx.coroutines.launch



class ContactsViewModel:ViewModel() {
    val contactsRepository = ContactsRepository()
    lateinit var contactLiveData: LiveData<Contact>
    lateinit var contactListLiveData: LiveData<List<Contact>>
    fun saveContact(contact: Contact) {
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }

    fun fetchContactById(contactId: Int) {

        contactLiveData = contactsRepository.getContactById(contactId)

    }

    fun allContacts() {

            contactListLiveData=   contactsRepository.getAllContacts()    //access to the function


    }
}



