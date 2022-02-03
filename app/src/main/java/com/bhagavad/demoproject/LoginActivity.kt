package com.bhagavad.demoproject



import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bhagavad.demoproject.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    //lateinit var mBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        setContentView(R.layout.activity_login)

       /* mBinding= DataBindingUtil.inflate(
            layoutInflater,
            R.layout.activity_login,
            (ViewGroup) findViewById(R.id.content_frame),
            false
        )*/
       // setContentView(mBinding.getRoot())



        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }



      /*  mBinding.tvSignup.setOnClickListener {
            val mIntent = Intent(this, SignupActivity::class.java)
            startActivity(mIntent)

        }*/

    }
}