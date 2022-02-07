package com.bhagavad.demoproject.dashboard



import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.bhagavad.demoproject.base.BaseActivity
import com.bhagavad.demoproject.toolbar.ToolBarViewModel
import com.bhagavad.demoproject.BR
import com.bhagavad.demoproject.R
import com.bhagavad.demoproject.dashboard.fragment.NotificationListFragment
import com.bhagavad.demoproject.databinding.ActivityDashboardBinding
import com.bhagavad.demoproject.server.serverResponseNavigator
import com.bhagavad.demoproject.viewmodalfactory.ViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity :  BaseActivity<ActivityDashboardBinding, DashboardViewModel, ToolBarViewModel>(),
    DashboardNavigator, serverResponseNavigator,  BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var mViewModel: DashboardViewModel
    private lateinit var mBinding: ActivityDashboardBinding
    private lateinit var mContext: Context
    private lateinit var mActivity: Activity
    var mBottomTabSelectedId: Int? = null
    var mFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()

    }

    fun initView()
    {
        mContext = this@DashboardActivity
        mActivity = this@DashboardActivity
        mBinding = getViewDataBinding()
        mViewModel.setNavigator(this)

        mBinding.bottomTabView.setOnNavigationItemSelectedListener(this)
        mBinding.bottomTabView.selectedItemId = mBinding.bottomTabView.menu.getItem(0).itemId
        mBinding.bottomTabView.itemIconTintList = null
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
       return R.layout.activity_dashboard
    }

    override fun getViewModel(): DashboardViewModel {
        mViewModel = ViewModelProvider(this, ViewModelProviderFactory(application, this))
            .get(DashboardViewModel::class.java)
        return mViewModel
    }

    override fun getToolBarViewModel(): ToolBarViewModel? {
        return null
    }

    override fun createAccountClick() {

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

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        if (mBottomTabSelectedId == menuItem.itemId) {
            return true;
        } else {

            mBottomTabSelectedId = menuItem.itemId;

        }

        when (menuItem.itemId) {


            R.id.tab1_fragment -> {
                mFragment = NotificationListFragment.newInstance();
            }

            R.id.tab2_fragment -> {
                mFragment = NotificationListFragment.newInstance();
            }

            R.id.tab3_fragment -> {
                mFragment = NotificationListFragment.newInstance();
            }


            R.id.tab4_fragment -> {
                mFragment = NotificationListFragment.newInstance();
            }
        }


        return manageFragment()
    }

    /*
 * manage fragment as per bottom tab selection
 * */
    fun manageFragment(): Boolean {

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction();

        if (mFragment != null) {
            fragmentTransaction.replace(R.id.frame_layout, mFragment!!).commit()
            return true;
        }
        return false;
    }

}