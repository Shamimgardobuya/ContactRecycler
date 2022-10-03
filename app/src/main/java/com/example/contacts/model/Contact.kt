package com.example.contacts.model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true) var contactId:Int,
    var name:String,
    var phoneNumber: String,
    var email:String,
    var address:String,
    var image: String
    //for the url of a dynamic image
)


