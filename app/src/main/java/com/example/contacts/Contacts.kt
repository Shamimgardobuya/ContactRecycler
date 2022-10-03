package com.example.contacts

import android.app.Application
import android.content.Context
import com.example.contacts.model.Contact
import com.example.contacts.repository.ContactsRepository

//will terminate once the app is dead
class Contacts:Application() {
    companion object{
        lateinit var appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext= applicationContext

    }


}
