package com.anushmp.contactranker.datamodels.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact:ContactEntity)

    @Query("select * from contactstable where primaryKeyId>:page order by primaryKeyId limit 20")
    fun getContacts(page:Int): List<ContactEntity>



}