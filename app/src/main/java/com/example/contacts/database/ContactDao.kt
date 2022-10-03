package com.example.contacts.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contacts.model.Contact

@Dao

interface ContactDao{
     @Insert(onConflict = OnConflictStrategy.REPLACE)  //conflct that already exists when addying an Contact
     fun insertContact(contact: Contact)

     @Query("SELECT * FROM contacts")
     fun getAllContacts():LiveData<List<Contact>>

     @Query("SELECT * FROM contacts WHERE contactId= :contactId")
     fun getContactById(contactId:Int):LiveData<Contact>

}