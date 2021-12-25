package com.anushmp.contactranker.datamodels.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ContactsTable")
data class ContactEntity(

    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber:String,
    @ColumnInfo(name = "rankValue")
    var rankValue:Int

){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "primaryKeyId")
    var id:Int = 1

}