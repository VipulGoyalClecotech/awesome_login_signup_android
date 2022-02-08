package com.bhagavad.demoproject.dashboard.fragment.home

import android.app.Application
import com.bhagavad.demoproject.base.BaseViewModel
import com.bhagavad.demoproject.server.*



class HomeListFragmentViewModel (application: Application, serverResponse: serverResponseNavigator) : BaseViewModel<HomeListFragmentNavigator>(application)
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