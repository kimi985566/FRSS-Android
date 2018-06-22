package com.ycy.frss.ui.fragment

import android.os.Bundle
import android.view.*
import com.ycy.baselibrary.ext.onClick
import com.ycy.baselibrary.ui.fragment.BaseFragment
import com.ycy.frss.R
import com.ycy.frss.ui.activity.EditActivity
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity

class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)//在Fragment中设置toolbar
        initView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_home, menu)
    }

    private fun initView() {
        mHomeFAB.onClick {

            startActivity<EditActivity>()

        }
    }

}