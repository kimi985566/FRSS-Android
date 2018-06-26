package com.ycy.frss.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ycy.baselibrary.ui.fragment.BaseFragment
import com.ycy.frss.R
import com.ycy.frss.ui.activity.EditActivity
import kotlinx.android.synthetic.main.fragment_edit_preview.*

class PreviewFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_edit_preview, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        (activity as EditActivity).setPreviewView(mMarkDownPreviewView)
    }

    fun setTitle(title: String) {
        mEditTitlePreviewTv!!.text = title
    }

    companion object {
        fun newInstance(): PreviewFragment {
            return PreviewFragment()
        }
    }
}