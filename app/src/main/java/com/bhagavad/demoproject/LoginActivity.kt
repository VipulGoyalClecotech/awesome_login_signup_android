package com.bhagavad.demoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
//import androidx.databinding.DataBindingUtil
//import com.bhagavad.demoproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //lateinit var mBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }
     /*   mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }
        mBinding.tvSignup.setOnClickListener {
            val mIntent = Intent(this, SignupActivity::class.java)
            startActivity(mIntent)

        }*/

    }
}