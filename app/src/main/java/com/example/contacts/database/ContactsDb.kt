package com.example.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contacts.model.Contact

@Database(entities = arrayOf(Contact::class), version = 1)  //holds specific data
abstract class ContactsDb:RoomDatabase() {
      abstract fun contactDao():ContactDao


      companion object{
          private var database :ContactsDb?= null

          fun getDatabase(context: Context):ContactsDb{
              if (database ==null){
                  database = Room
                      .databaseBuilder(context,ContactsDb::class.java,"ContactsDB")
                      .fallbackToDestructiveMigration()
                      .build()

              }
              return database as ContactsDb
          }

      }

}