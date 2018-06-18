package com.ycy.markdown.Utils

import android.text.Editable
import android.text.TextWatcher
import android.util.Pair
import com.ycy.markdown.View.MarkDownEditorView
import com.ycy.markdown.View.MarkDownPreviewView
import com.ycy.markdown.Adapter.ToolsAdapter
import com.ycy.markdown.Listener.OnPreInsertListener


class MarkDownController(private val editorView: MarkDownEditorView, private val previewView: MarkDownPreviewView, private val toolsAdapter: ToolsAdapter, autoPreview: Boolean) : TextWatcher {

    private var autoPreview = false

    internal constructor(editorView: MarkDownEditorView, previewView: MarkDownPreviewView, toolsAdapter: ToolsAdapter) : this(editorView, previewView, toolsAdapter, true) {}

    init {

        //bind toolsAdapter to editorView
        this.toolsAdapter.setEditor(this.editorView)

        //preview
        preview()

        //set autoPreview true or false
        setAutoPreview(autoPreview)
    }

    private fun setAutoPreview(autoPreview: Boolean) {
        if (this.autoPreview == autoPreview)
            return
        this.autoPreview = autoPreview
        if (autoPreview)
            editorView.addTextChangedListener(this)
        else
            editorView.removeTextChangedListener(this)
    }

    fun setOnPreInsertListener(listener: OnPreInsertListener) {
        toolsAdapter.setOnPreInsertListener(listener)
    }

    fun insertImage(url: String) {
        editorView.insertImage(url)
    }

    fun insertLink(info: Pair<String, String>) {
        editorView.insertLink(info)
    }

    fun insertTable(size: Pair<Int, Int>) {
        editorView.insertTable(size)
    }

    private fun preview() {
        previewView.preview(editorView.text.toString() + "")
    }

    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

    }

    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

    }

    override fun afterTextChanged(editable: Editable) {
        preview()
    }
}
