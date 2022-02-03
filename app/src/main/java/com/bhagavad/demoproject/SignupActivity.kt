package com.bhagavad.demoproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

//import com.bhagavad.demoproject.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
   // lateinit var mBinding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // mBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        setContentView(R.layout.activity_signup)
       if (getSupportActionBar() != null) {
           getSupportActionBar()?.hide();
       }

     /*   mBinding.tvLogin.setOnClickListener {
          finish()

        }
        mBinding.ivBack.setOnClickListener {
            finish()

        }*/

    }
}