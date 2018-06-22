package com.ycy.frss.ui.activity

import android.os.Bundle
import com.ycy.baselibrary.ui.activity.BaseActivity
import com.ycy.frss.R

class EditActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(findViewById(R.id.mToolbar))
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }
}