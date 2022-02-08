package com.bhagavad.demoproject.homedetail

import android.app.Application
import android.text.TextUtils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.base.BaseViewModel
import com.bhagavad.demoproject.server.*




class HomeDetailViewModel(application: Application, serverResponse: serverResponseNavigator) :
    BaseViewModel<HomeDetailNavigator>(application) {
    lateinit var serverResponse: serverResponseNavigator
    var mApplication: Application

    init {
        mApplication = application
        this.serverResponse = serverResponse
    }

    /**
     * To pass  result to activity
     */
    private val dataResult = MutableLiveData<String>()

    /*
  * get  result live data
  * */
    fun geResult(): LiveData<String> = dataResult


}