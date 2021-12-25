package com.anushmp.contactranker.trash

import android.util.Log
import androidx.lifecycle.MutableLiveData

class TrashThread(val counter:MutableLiveData<Int>):Thread() {

    var running = true

    override fun run() {

        var count = 0

        while(running){


            try{
                sleep(1000)
                Log.d("Thread",count.toString())
                count++
                counter.postValue(count)


            }catch (e:Exception){}


        }



    }

}