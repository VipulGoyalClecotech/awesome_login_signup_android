package com.bhagavad.demoproject.viewmodalfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.bhagavad.demoproject.login.LoginViewModel
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.signup.SignupViewModel


class ViewModelProviderFactory(
    private val application: Application,
    serverResponse: serverResponseNavigator
)

    : ViewModelProvider.AndroidViewModelFactory(application) {


    lateinit var serverResponse: serverResponseNavigator;

    init {
        this.serverResponse = serverResponse;
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(application, serverResponse) as T
        }
        else if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            return SignupViewModel(application, serverResponse) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name) as Throwable

    }

}
