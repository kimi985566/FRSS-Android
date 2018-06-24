package com.ycy.frss.ui.activity

import android.os.Bundle
import com.ycy.baselibrary.ui.activity.BaseActivity
import com.ycy.frss.R
import com.ycy.markdown.Adapter.ToolsAdapter
import com.ycy.markdown.Listener.OnPreInsertListener
import com.ycy.markdown.Utils.MarkDownController
import com.ycy.markdown.View.MarkDownEditorView
import com.ycy.markdown.View.MarkDownPreviewView

class EditActivity : BaseActivity(), OnPreInsertListener {
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

    fun setEditorView(editorView: MarkDownEditorView?) {
        mEditorView = editorView
        if (editorView != null && mPreviewView != null && mToolsAdapter != null)
            initMarkDownController()
    }

    fun setPreviewView(previewView: MarkDownPreviewView?) {
        mPreviewView = previewView
        if (mEditorView != null && previewView != null && mToolsAdapter != null)
            initMarkDownController()
    }

    private fun initMarkDownController() {
        mMarkDownController = MarkDownController(mEditorView!!, mPreviewView!!, mToolsAdapter!!, false)
        mMarkDownController!!.setOnPreInsertListener(this)
    }

    override fun onPreInsertImage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPreInsertLink() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPreInsertTable() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private var mEditorView: MarkDownEditorView? = null
        private var mPreviewView: MarkDownPreviewView? = null
        private var mMarkDownController: MarkDownController? = null
        private var mToolsAdapter: ToolsAdapter? = null
    }
}