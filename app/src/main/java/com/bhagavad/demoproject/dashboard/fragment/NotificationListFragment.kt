package com.bhagavad.demoproject.dashboard.fragment

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhagavad.demoproject.BR
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.base.BaseActivity
import com.bhagavad.demoproject.base.BaseFragment
import com.bhagavad.demoproject.dashboard.fragment.notification.NotificationListFragmentNavigator
import com.bhagavad.demoproject.dashboard.fragment.notification.NotificationListFragmentViewModel
import com.bhagavad.demoproject.dashboard.fragment.notification.adapter.NotificationListAdapter
import com.bhagavad.demoproject.dashboard.fragment.notification.bean.NotificationListResponse
import com.bhagavad.demoproject.databinding.FragmentNotificationListBinding
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.util.*
import com.bhagavad.demoproject.viewmodalfactory.ViewModelProviderFactory


class NotificationListFragment :
    BaseFragment<FragmentNotificationListBinding, NotificationListFragmentViewModel>(),
    serverResponseNavigator, NotificationListFragmentNavigator {
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    lateinit var mViewModel: NotificationListFragmentViewModel
    var mShowNetworkDialog: Dialog? = null
    lateinit var mBinding: FragmentNotificationListBinding
    lateinit var mClassesList: ArrayList<NotificationListResponse.Data>
    lateinit var mAdapter: NotificationListAdapter
    lateinit var mLayoutManager: LinearLayoutManager
    private var description = ""
    private var currentPage: Int = 1

    private var isLoadMoreClassesList: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }


    fun initViews() {
        mContext = this@NotificationListFragment.activity!!
        mActivity = this@NotificationListFragment.activity!!
        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)
        AppUtil.setupUI(mBinding.llMain, mActivity)
        mClassesList = ArrayList()

        //these is adapter initialization of notification list
        mLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        mBinding.rvNotificationList.setHasFixedSize(true)
        mBinding.rvNotificationList.setLayoutManager(mLayoutManager)
        mBinding.rvNotificationList.setItemAnimator(DefaultItemAnimator())
        mAdapter = NotificationListAdapter(mContext, mClassesList, mViewModel, this)
        mBinding.rvNotificationList.setAdapter(mAdapter)

        mClassesList.add(NotificationListResponse.Data("1","Course 1", "Description 1","Vipul Goyal",""))
        mClassesList.add(NotificationListResponse.Data("2","Course 2", "Description 2","Aman Nawal",""))
        mClassesList.add(NotificationListResponse.Data("3","Course 3", "Description 3","Pulkit Garg",""))
        mClassesList.add(NotificationListResponse.Data("4","Course 4", "Description 4","Vivek Bansal",""))
        mClassesList.add(NotificationListResponse.Data("5","Course 5", "Description 5","Gaurav Garg",""))

        mAdapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)
        initViews()
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            NotificationListFragment().apply {

            }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_notification_list
    }

    override fun getViewModel(): NotificationListFragmentViewModel {
        mViewModel =
            ViewModelProvider(this, ViewModelProviderFactory(activity!!.application, this)).get(
                NotificationListFragmentViewModel::class.java
            )
        return mViewModel
    }


    override fun showLoaderOnRequest(isShowLoader: Boolean) {
        if (isShowLoader && mShowNetworkDialog == null) {
            mShowNetworkDialog = DialogUtil.showLoader(mContext!!)
        } else if (isShowLoader && !mShowNetworkDialog!!.isShowing()) {
            mShowNetworkDialog = null
            mShowNetworkDialog = DialogUtil.showLoader(mContext!!)
        } else {
            if (mShowNetworkDialog != null && isShowLoader == false) {
                DialogUtil.hideLoaderDialog(mShowNetworkDialog!!)
                mShowNetworkDialog = null
            }
        }
    }

    override fun onResponse(eventType: String, response: String) {
        showLoaderOnRequest(false)

    }

    override fun onRequestFailed(eventType: String, response: String) {
        showLoaderOnRequest(false)
        showMessage(response)


    }

    override fun onRequestRetry() {
        showLoaderOnRequest(false)

    }

    override fun onSessionExpire() {
        showLoaderOnRequest(false)
        BaseActivity.showErrorMessage(
            mContext,
            getString(R.string.session_expire_msg),
            true
        )
    }

    override fun onMinorUpdate() {
        showLoaderOnRequest(false)
        BaseActivity.showMinorUpdateMessage(
            mContext,
            getString(R.string.new_update_available),
            false
        )
    }

    override fun onAppHardUpdate() {
        showLoaderOnRequest(false)
        BaseActivity.showHardUpdateMessage(
            mContext,
            getString(R.string.new_update_available),
            true
        )
    }

    override fun noNetwork() {
        showLoaderOnRequest(false)
        BaseActivity.showErrorMessage(
            mContext,
            getString(R.string.No_internet_connection),
            false
        )
    }

    /*
        * show all common message from one place
        * */
    fun showMessage(msg: String) {
        DialogUtil.okCancelDialog(mContext!!,
            getString(R.string.app_name), msg, getString(R.string.ok),
            "", true, false, object : DialogUtil.Companion.selectOkCancelListener {
                override fun okClick() {

                }

                override fun cancelClick() {

                }

            });
    }



    override fun listItemClick(position: Int) {

    }



    override fun onNoRecordClick() {

    }


}