package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.contacts.databinding.ActivityViewContactBinding
import com.example.contacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class viewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun getExtras(){
        val extras=intent.extras  //IS A NULL value
        val name=extras?.getString("NAME","")
        val email=extras?.getString("EMAIL","")
        val phone=extras?.getString("PHONENUMBER","")

        val image=binding.imgContactView
//        val icona=binding.imgPhoneCall
//        val iconb=binding.imgMess
        val addressing=extras?.getString("ADDRESS","")





        Toast.makeText(this,"$name: $email",Toast.LENGTH_LONG).show()
        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,phone,Toast.LENGTH_LONG).show()
        Toast.makeText(this,addressing,Toast.LENGTH_LONG).show()



        binding.tvUserName.text=name
        binding.tvAdress2.text=addressing
        binding.tvPhoning.text=phone



//        binding.
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)
        
    }
    }
