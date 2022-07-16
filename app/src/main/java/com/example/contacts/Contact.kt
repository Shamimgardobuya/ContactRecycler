package com.example.contacts

import android.media.Image

data class Contact(
    var name:String,
    var phoneNumber: String,
    var email:String,
    var address:String,
    var image: String
    //for the url of a dynamic image
)

