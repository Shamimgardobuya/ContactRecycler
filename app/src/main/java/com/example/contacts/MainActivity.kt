package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()

    }
    fun displayContacts(){
        var contact1=Contact("Alby","0733488127","alby@gmail.com","348Kilian","https://images.pexels.com/photos/935985/pexels-photo-935985.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact2=Contact("Bizwa","0784349833","bizwa@gmail.com","Patel34","https://images.pexels.com/photos/3746214/pexels-photo-3746214.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contacct3=Contact("Maggie","079175652","anab@gmail.com","Mel56","https://images.pexels.com/photos/813940/pexels-photo-813940.jpeg?auto=compress&cs=tinysrgb&w=400")
        var contact4=Contact("Lynne","0783847775","lynne@gmail.com","NMH908","https://images.pexels.com/photos/3769021/pexels-photo-3769021.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
        var contact5=Contact("Anita","058677994","anita@gmail.com","QIR567","https://images.pexels.com/photos/r")
       var contactsList= listOf(contact1,contact2,contacct3,contact4,contact5)
        var contactsAdapter=ContactsRvAdapter(contactsList)
        binding.rvContacts.layoutManager=LinearLayoutManager(this)
        binding.rvContacts.adapter=contactsAdapter
    }

}