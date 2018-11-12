package com.blopez.kotlinmvvmjetpackkoin.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.blopez.kotlinmvvmjetpackkoin.BR
import com.blopez.kotlinmvvmjetpackkoin.R
import com.blopez.kotlinmvvmjetpackkoin.common.base.BaseActivity
import com.blopez.kotlinmvvmjetpackkoin.databinding.MainActivityBinding
import com.blopez.kotlinmvvmjetpackkoin.ui.home.HomeFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    //TODO Inject dagger
    private val mViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.navHostFragment).navigateUp()


    override fun getViewModel(): MainViewModel {
        return mViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override fun attachObserver() {

        //Example: Observe title variable
        mViewModel.title.observe(this, Observer<String> { value ->
            value?.let { tv_title.text = it }
        })

    }
}
