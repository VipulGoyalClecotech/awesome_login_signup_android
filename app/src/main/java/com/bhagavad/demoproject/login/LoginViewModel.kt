package com.bhagavad.demoproject.login

import android.app.Application
import android.text.TextUtils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.base.BaseViewModel
import com.bhagavad.demoproject.server.*




class LoginViewModel(application: Application, serverResponse: serverResponseNavigator) :
    BaseViewModel<LoginNavigator>(application) {
    lateinit var serverResponse: serverResponseNavigator
    var mApplication: Application
   // lateinit var mRxApiCallHelper: RxAPICallHelper
   // lateinit var mApiInterface: ApiInterface
   var emailStr: String = ""
    var passwordStr: String = ""
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

    fun loginClick() {
        if (TextUtils.isEmpty(emailStr.trim())) {
            dataResult.value = getStringfromVM(R.string.please_enter_email)
            return;
        }
        else if (TextUtils.isEmpty(passwordStr.trim())) {
            dataResult.value = getStringfromVM(R.string.please_enter_password)
            return;
        }
        else {
            dataResult.value = "";
            return
        }
    }

}