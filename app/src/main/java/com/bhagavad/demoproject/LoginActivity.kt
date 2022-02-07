package com.bhagavad.demoproject



import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bhagavad.demoproject.base.BaseActivity
import com.bhagavad.demoproject.databinding.ActivityLoginBinding
import com.bhagavad.demoproject.login.LoginNavigator
import com.bhagavad.demoproject.login.LoginViewModel
import com.bhagavad.demoproject.toolbar.ToolBarViewModel
import androidx.lifecycle.Observer
import com.bhagavad.demoproject.dashboard.DashboardActivity
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.util.AppUtil
import com.bhagavad.demoproject.util.DialogUtil
import com.bhagavad.demoproject.viewmodalfactory.ViewModelProviderFactory

class LoginActivity :  BaseActivity<ActivityLoginBinding, LoginViewModel, ToolBarViewModel>(),
    LoginNavigator, serverResponseNavigator {
    private lateinit var mViewModel: LoginViewModel
    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    fun initView()
    {
        mContext = this@LoginActivity
        mActivity = this@LoginActivity
        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)

        mViewModel.geResult().observe(this, Observer { result ->

            if (result.equals("")) {

                AppUtil.startIntent(null, mActivity, DashboardActivity::class.java)


            } else {
                showMessage(result)
            }
        })
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_login
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


    override fun getViewModel(): LoginViewModel {
        mViewModel = ViewModelProvider(this, ViewModelProviderFactory(application, this))
            .get(LoginViewModel::class.java)
        return mViewModel
    }

    override fun getToolBarViewModel(): ToolBarViewModel? {
        return null
    }

    override fun createAccountClick() {
        AppUtil.startIntent(null, mActivity, SignupActivity::class.java)
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
}