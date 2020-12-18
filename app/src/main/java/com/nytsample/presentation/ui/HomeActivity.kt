package com.nytsample.presentation.ui

import android.os.Bundle
import com.nytsample.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setSupportActionBar(toolbar)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MostPopularListFragment.newInstance())
                .commitNow()
        }
    }
}