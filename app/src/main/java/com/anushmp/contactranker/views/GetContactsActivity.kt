package com.anushmp.contactranker.views

import android.content.ContentResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.loader.content.CursorLoader
import com.anushmp.contactranker.R

class GetContactsActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_contacts)

        val contactsResolver = contentResolver
        val contactsCursorLoader = CursorLoader(this)

        contactsCursorLoader.uri = ContactsContract.Contacts.CONTENT_URI
        contactsCursorLoader.projection = arrayOf(ContactsContract.Contacts.DISPLAY_NAME,
        ContactsContract.Contacts.HAS_PHONE_NUMBER,
        ContactsContract.Contacts.NAME_RAW_CONTACT_ID,
        ContactsContract.Contacts._ID)
        //val cursor = contactsCursorLoader.loadInBackground()



        val cursor = contactsResolver.query(ContactsContract.Contacts.CONTENT_URI,
        null,
        null,
        null,
        null)

        cursor?.let { cursor1 ->
            if(cursor1.moveToFirst()){
                do{
                    var displayNameIndex = cursor1.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                    var rawindex = cursor1.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID)
                    var idindex = cursor1.getColumnIndex(ContactsContract.Contacts._ID)
                    var id = cursor1.getString(idindex)
                    var rawid = cursor1.getString(rawindex)
                    var name = cursor1.getString(displayNameIndex)
                    Log.d("contact", name)

                    var hasPhone = cursor1.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)
                    //Log.d("contacts",hasPhone.toString())
                    if(hasPhone>0){
                        var numCur = contactsResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ " = ?",
                            arrayOf(id),
                            null
                        )

                        //Log.d("numCur", numCur.toString())

                        numCur?.let {

                            it.moveToFirst()
                            //Log.d("numCUR","entering let block")

                            while(it.moveToNext()){

                                var colin = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                                var phoneNumber = it.getString(colin)
                                Log.d("contacts", phoneNumber)

                            }

                            it.close()

                        }



                    }

                }while (cursor1.moveToNext())


            }

            cursor1.close()
        }


    }
}