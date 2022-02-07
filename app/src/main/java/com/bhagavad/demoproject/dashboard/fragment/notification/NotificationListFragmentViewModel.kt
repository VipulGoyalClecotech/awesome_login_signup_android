package com.bhagavad.demoproject.dashboard.fragment.notification

import android.app.Application
import com.bhagavad.demoproject.base.BaseViewModel
import com.bhagavad.demoproject.server.*



class NotificationListFragmentViewModel (application: Application, serverResponse: serverResponseNavigator) : BaseViewModel<NotificationListFragmentNavigator>(application)
{
    var mApplication: Application
    lateinit var serverResponse: serverResponseNavigator



    init
    {
        mApplication = application
        this.serverResponse = serverResponse
    }



    fun listItemClick(position:Int)
{
    getNavigator().listItemClick(position)
}



    fun onNoRecordClick() {
        getNavigator().onNoRecordClick()
    }

}