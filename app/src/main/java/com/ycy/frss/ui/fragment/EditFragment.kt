package com.ycy.frss.ui.fragment

import android.os.Bundle
import com.ycy.baselibrary.ui.fragment.BaseFragment

class EditFragment : BaseFragment() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mTitle = arguments!!.getString(TITLE)
            mContent = arguments!!.getString(CONTENT)
        }
    }


}