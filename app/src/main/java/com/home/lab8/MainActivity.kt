package com.home.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter
    private val contacts = ArrayList<Contact>()
    val addContact = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        adapter = ContactAdapter(contacts)
        recyclerView.adapter = adapter
        btn_add.setOnClickListener {
            startActivityForResult(Intent(this, AddActivity::class.java), addContact)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {
            if(requestCode == addContact && resultCode == Activity.RESULT_OK) {
                contacts.add(Contact(it.getString("name").toString(), it.getString("phone").toString()))
                adapter.notifyDataSetChanged()
            }
        }
    }
}

data class Contact (
    val name: String,
    val phone: String
)
