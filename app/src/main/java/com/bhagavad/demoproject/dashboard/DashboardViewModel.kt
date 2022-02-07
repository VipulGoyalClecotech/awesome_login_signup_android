package com.bhagavad.demoproject.dashboard

import android.app.Application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.base.BaseViewModel
import com.bhagavad.demoproject.server.*




class DashboardViewModel(application: Application, serverResponse: serverResponseNavigator) :
    BaseViewModel<DashboardNavigator>(application) {
    lateinit var serverResponse: serverResponseNavigator
    var mApplication: Application
   // lateinit var mRxApiCallHelper: RxAPICallHelper
   // lateinit var mApiInterface: ApiInterface


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

    fun createAccountClick() {
        getNavigator().createAccountClick()
    }

}