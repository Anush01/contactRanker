package com.anushmp.contactranker.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anushmp.contactranker.R
import com.anushmp.contactranker.datamodels.local.ContactClass
import com.anushmp.contactranker.views.adapters.ContactsAdapter
import org.jetbrains.anko.find

class ContactFetcherActivity : AppCompatActivity() {


    val contactList: ArrayList<ContactClass> by lazy { ArrayList() }
    lateinit var tvContacts:TextView
    lateinit var rvContacts:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_fetcher)
        tvContacts = findViewById(R.id.tvcontacts)
        rvContacts = findViewById(R.id.contactsRV)


        tvContacts.visibility = View.GONE

        var contentResolver = contentResolver
        var uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI

        var cursor = contentResolver.query(uri,
        null,
        null,
        null,
        null)


        Log.d("anush",cursor.toString())

        cursor?.let {

            if(it.count>0){

                it.moveToFirst()

                do {

                    var nameColumnIndex  = it.getColumnIndex(ContactsContract
                        .CommonDataKinds.Phone.DISPLAY_NAME)

                    var numberColumnIndex = it.getColumnIndex(ContactsContract
                        .CommonDataKinds.Phone.NUMBER)

                    var name = it.getString(nameColumnIndex)
                    var number = it.getString(numberColumnIndex)

                    //Log.d("kooooooo", "$name and $number")

                    //contactList.add("$name + $number")

                    val contactClass = ContactClass(name,number,0)
                    contactList.add(contactClass)

                }while (it.moveToNext())

                it.close()
            }

        }

        val contactsAdapter = ContactsAdapter(this,contactList)
        val llm = LinearLayoutManager(this)
        rvContacts.adapter = contactsAdapter
        rvContacts.layoutManager = llm

//        for(i in 0 until 5){
//
//            tvContacts.append("\n" + contactList[i])
//
//
//        }


    }
}