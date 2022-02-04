package com.bhagavad.demoproject.signup

import android.app.Application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.base.BaseViewModel
import com.bhagavad.demoproject.server.*




class SignupViewModel(application: Application, serverResponse: serverResponseNavigator) :
    BaseViewModel<SignupNavigator>(application) {
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

    fun loginClick() {
        getNavigator().loginClick()
    }

}