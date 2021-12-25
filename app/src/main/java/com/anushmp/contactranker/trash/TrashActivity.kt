package com.anushmp.contactranker.trash

import android.content.ContentResolver
import android.os.Bundle
import android.provider.ContactsContract
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.content.CursorLoader
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.anushmp.contactranker.R
import com.anushmp.contactranker.databinding.ActivityTrash2Binding


class TrashActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTrash2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTrash2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_trash2)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }



//        val contentResolver = contentResolver
//        val cursorLoader = CursorLoader(this)
//        cursorLoader.uri = ContactsContract.Contacts.CONTENT_URI
//        cursorLoader.projection = arrayOf(
//            ContactsContract.Contacts.DISPLAY_NAME)
//        val cursor = cursorLoader.loadInBackground()


//        var thread = TrashThread()
//        thread.start()


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_trash2)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }




}