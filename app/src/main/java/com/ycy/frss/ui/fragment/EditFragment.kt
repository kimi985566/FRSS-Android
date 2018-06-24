package com.ycy.frss.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ycy.baselibrary.ui.fragment.BaseFragment
import com.ycy.frss.R
import com.ycy.frss.ui.activity.EditActivity
import kotlinx.android.synthetic.main.fragment_edit_main.*

class EditFragment : BaseFragment() {

    val title: String
        get() = mEditTitleTv!!.text.toString() + ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mTitle = arguments!!.getString(TITLE)
            mContent = arguments!!.getString(CONTENT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_edit_main, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        mEditTitleTv!!.setText(mTitle)
        mMarkDownEditorView!!.setText(mContent)
        (activity as EditActivity).setEditorView(mMarkDownEditorView)
    }

    companion object {

        private const val TITLE = "title"
        private const val CONTENT = "content"

        private var mTitle: String? = null
        private var mContent: String? = null

        fun newInstance(title: String, content: String): EditFragment {
            val fragment = EditFragment()
            val args = Bundle()
            args.putString(TITLE, title)
            args.putString(CONTENT, content)
            fragment.arguments = args
            return fragment
        }
    }

}