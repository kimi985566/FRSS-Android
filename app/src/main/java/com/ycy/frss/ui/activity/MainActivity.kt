package com.ycy.frss.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.ycy.baselibrary.ui.activity.BaseActivity
import com.ycy.frss.R
import com.ycy.frss.ui.fragment.EditFragment
import com.ycy.frss.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        private val mStack = Stack<Fragment>()
        //主界面Fragment
        private val mHomeFragment by lazy { HomeFragment() }
        //编辑界面
        private val mEditFragment by lazy { EditFragment() }

        private lateinit var drawerToggle: ActionBarDrawerToggle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initNavView()
        initFragments()
        changeFragment(0)//初始化第一页的Fragment
    }

    private fun initFragments() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mHomeContainer, mHomeFragment)
        manager.add(R.id.mHomeContainer, mEditFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mEditFragment)
    }

    //设置ToolBar
    private fun initToolbar() {
        setSupportActionBar(findViewById(R.id.mToolbar))
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }

    //设置侧边栏
    private fun initNavView() {
        drawerToggle = ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close)
        mDrawerLayout.addDrawerListener(drawerToggle)
        mHomeNavView.setNavigationItemSelectedListener(this)
    }

    //点击drawerToggle菜单按钮
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sync the toggle state after has occurred.
        drawerToggle.syncState()//菜单三条杠
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mNavMenuHomePage -> {
                changeFragment(item.order)
            }
            R.id.mNavMenuEditPage -> {
                changeFragment(item.order)
            }
            R.id.mNavMenuAboutPage -> {
                toast(item.order.toString())
            }
        }
        mDrawerLayout.closeDrawers()
        return true
    }

    //切换Tab，切换对应的Fragment
    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }
}