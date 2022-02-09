package com.bhagavad.demoproject.homedetail



import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bhagavad.demoproject.base.BaseActivity
import com.bhagavad.demoproject.toolbar.ToolBarViewModel
import androidx.lifecycle.Observer
import com.bhagavad.demoproject.dashboard.DashboardActivity
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.util.AppUtil
import com.bhagavad.demoproject.util.DialogUtil
import com.bhagavad.demoproject.viewmodalfactory.ViewModelProviderFactory
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.BR
import com.bhagavad.demoproject.dashboard.fragment.home.bean.HomeListResponse
import com.bhagavad.demoproject.databinding.ActivityHomeDetailBinding
import com.bhagavad.demoproject.toolbar.ToolBarNavigator

class HomeDetailActivity :  BaseActivity<ActivityHomeDetailBinding, HomeDetailViewModel, ToolBarViewModel>(),
    HomeDetailNavigator, serverResponseNavigator, ToolBarNavigator {
    private lateinit var mViewModel: HomeDetailViewModel
    private lateinit var mBinding: ActivityHomeDetailBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    lateinit var mToolBarViewModel: ToolBarViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    fun initView()
    {
        mContext = this@HomeDetailActivity
        mActivity = this@HomeDetailActivity
        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)
        mBinding.toolBar.collapseToolBarModel = mToolBarViewModel
        mToolBarViewModel!!.setToolBarNavigator(this)
        mBinding.toolBar.ibLeft.visibility=View.VISIBLE

        // Get Intent Data
        val bundle = intent.extras
        var data=bundle!!.getParcelable<HomeListResponse.Data>("data")
       // var courseStr = bundle!!.getString("course")!!
       // var descriptionStr = bundle!!.getString("description")!!

        mBinding.tvTopic.setText(data!!.description)
        mBinding.tvSubject.setText(data!!.course)

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_home_detail
    }


    /*
        * show all common message
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


    override fun getViewModel(): HomeDetailViewModel {
        mViewModel = ViewModelProvider(this, ViewModelProviderFactory(application, this))
            .get(HomeDetailViewModel::class.java)
        return mViewModel
    }

    override fun getToolBarViewModel(): ToolBarViewModel? {
        mToolBarViewModel =
            ViewModelProvider(this, ViewModelProviderFactory(application, this)).get(
                ToolBarViewModel::class.java
            )
        return mToolBarViewModel
    }


    override fun showLoaderOnRequest(isShowLoader: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onResponse(eventType: String, response: String) {
        TODO("Not yet implemented")
    }

    override fun onRequestFailed(eventType: String, response: String) {
        TODO("Not yet implemented")
    }

    override fun onRequestRetry() {
        TODO("Not yet implemented")
    }

    override fun onSessionExpire() {
        TODO("Not yet implemented")
    }

    override fun onMinorUpdate() {
        TODO("Not yet implemented")
    }

    override fun onAppHardUpdate() {
        TODO("Not yet implemented")
    }

    override fun noNetwork() {
        TODO("Not yet implemented")
    }

    override fun backClick() {
        finish()
    }
}