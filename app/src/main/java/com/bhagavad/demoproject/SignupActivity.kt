package com.bhagavad.demoproject



import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bhagavad.demoproject.base.BaseActivity
import com.bhagavad.demoproject.databinding.ActivitySignupBinding
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.signup.SignupNavigator
import com.bhagavad.demoproject.signup.SignupViewModel
import com.bhagavad.demoproject.toolbar.ToolBarViewModel
import com.bhagavad.demoproject.util.AppUtil
import com.bhagavad.demoproject.viewmodalfactory.ViewModelProviderFactory


class SignupActivity :  BaseActivity<ActivitySignupBinding, SignupViewModel, ToolBarViewModel>(),
    SignupNavigator, serverResponseNavigator {
    private lateinit var mViewModel: SignupViewModel
    private lateinit var mBinding: ActivitySignupBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()


    }

    fun initView()
    {
        mContext = this@SignupActivity
        mActivity = this@SignupActivity
        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)

        mBinding.ivBack.setOnClickListener { finish() }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_signup
    }

    override fun getViewModel(): SignupViewModel {
        mViewModel = ViewModelProvider(this, ViewModelProviderFactory(application, this))
            .get(SignupViewModel::class.java)
        return mViewModel
    }

    override fun getToolBarViewModel(): ToolBarViewModel? {
        return null
    }

    override fun loginClick() {
      finish()
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