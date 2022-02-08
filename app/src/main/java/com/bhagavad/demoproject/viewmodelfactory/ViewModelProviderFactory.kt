package com.bhagavad.demoproject.viewmodalfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bhagavad.demoproject.dashboard.DashboardViewModel
import com.bhagavad.demoproject.dashboard.fragment.home.HomeListFragmentViewModel
import com.bhagavad.demoproject.dashboard.fragment.notification.NotificationListFragmentViewModel
import com.bhagavad.demoproject.homedetail.HomeDetailViewModel

import com.bhagavad.demoproject.login.LoginViewModel
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.signup.SignupViewModel
import com.bhagavad.demoproject.toolbar.ToolBarViewModel


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
         else if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
             return DashboardViewModel(application, serverResponse) as T
         }
         else if (modelClass.isAssignableFrom(NotificationListFragmentViewModel::class.java)) {
             return NotificationListFragmentViewModel(application, serverResponse) as T
         }
         else if (modelClass.isAssignableFrom(HomeListFragmentViewModel::class.java)) {
             return HomeListFragmentViewModel(application, serverResponse) as T
         }
         else if (modelClass.isAssignableFrom(HomeDetailViewModel::class.java)) {
             return HomeDetailViewModel(application, serverResponse) as T
         }
         else if (modelClass.isAssignableFrom(ToolBarViewModel::class.java)) {
             return ToolBarViewModel(application) as T
         }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name) as Throwable

    }

}
