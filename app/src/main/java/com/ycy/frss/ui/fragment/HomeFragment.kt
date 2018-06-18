package com.ycy.frss.ui.fragment

import android.os.Bundle
import android.view.*
import com.ycy.baselibrary.ext.onClick
import com.ycy.baselibrary.ui.fragment.BaseFragment
import com.ycy.baselibrary.utils.ColoredSnackBar
import com.ycy.frss.R
import kotlinx.android.synthetic.main.fragment_home.*

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
            ColoredSnackBar.confirm(mHomeFAB, "FAB Clicked").show()
        }
    }

}