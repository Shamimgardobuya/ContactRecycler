package com.example.contacts.repository

import androidx.lifecycle.LiveData
import com.example.contacts.Contacts
import com.example.contacts.database.ContactsDb
import com.example.contacts.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDb.getDatabase(Contacts.appContext) //pass context

    suspend fun saveContact(contact: Contact) {
        withContext(Dispatchers.IO) {
            database.contactDao().insertContact(contact)
        }
    }

    fun getContactById(contactId: Int): LiveData<Contact> {
        return database.contactDao().getContactById(contactId)
    }

    fun getAllContacts(): LiveData<List<Contact>> {
            return  database.contactDao().getAllContacts()

        }
    }

