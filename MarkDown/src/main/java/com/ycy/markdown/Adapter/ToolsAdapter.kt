package com.ycy.markdown.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.ycy.markdown.Listener.OnPreInsertListener
import com.ycy.markdown.View.MarkDownEditorView
import com.ycy.markdown.R


open class ToolsAdapter(private val inflater: LayoutInflater) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {
    private var editor: MarkDownEditorView? = null
    private var listener: OnPreInsertListener? = null

    fun setEditor(editor: MarkDownEditorView) {
        this.editor = editor
    }

    fun setOnPreInsertListener(listener: OnPreInsertListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ToolsViewHolder(inflater.inflate(R.layout.imgbtn_tool, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ToolsViewHolder).setImage(toolsRes[position])
    }

    override fun getItemCount(): Int {
        return toolsRes.size
    }

    override fun onClick(view: View) {
        if (editor == null)
            return
        val tag = view.tag as Int
        if (tag == R.drawable.ic_format_header_1)
            editor!!.header(1)
        else if (tag == R.drawable.ic_format_header_2)
            editor!!.header(2)
        else if (tag == R.drawable.ic_format_header_3)
            editor!!.header(3)
        else if (tag == R.drawable.ic_format_header_4)
            editor!!.header(4)
        else if (tag == R.drawable.ic_format_header_5)
            editor!!.header(5)
        else if (tag == R.drawable.ic_format_header_6)
            editor!!.header(6)
        else if (tag == R.drawable.ic_insert_line)
            editor!!.insertLine()
        else if (tag == R.drawable.ic_format_bold)
            editor!!.bold()
        else if (tag == R.drawable.ic_format_italic)
            editor!!.italic()
        else if (tag == R.drawable.ic_format_strikethrough)
            editor!!.strikethrough()
        else if (tag == R.drawable.ic_format_list_unordered)
            editor!!.unordered()
        else if (tag == R.drawable.ic_format_list_ordered)
            editor!!.ordered()
        else if (tag == R.drawable.ic_insert_image) {
            if (listener != null)
                listener!!.onPreInsertImage()
        } else if (tag == R.drawable.ic_insert_link) {
            if (listener != null)
                listener!!.onPreInsertLink()
        } else if (tag == R.drawable.ic_format_blockquote)
            editor!!.blockQuote()
        else if (tag == R.drawable.ic_insert_code_single)
            editor!!.codeSingle()
        else if (tag == R.drawable.ic_insert_code)
            editor!!.code()
        else if (tag == R.drawable.ic_insert_table) {
            if (listener != null)
                listener!!.onPreInsertTable()
        }
    }

    private inner class ToolsViewHolder internal constructor(internal var view: View) : RecyclerView.ViewHolder(view) {

        init {
            this.view.setOnClickListener(this@ToolsAdapter)
        }

        internal fun setImage(resId: Int) {
            (view as ImageButton).setImageResource(resId)
            view.tag = resId
        }
    }

    companion object {
        protected var toolsRes = intArrayOf(
                R.drawable.ic_format_header_1,
                R.drawable.ic_format_header_2,
                R.drawable.ic_format_header_3,
                R.drawable.ic_format_header_4,
                R.drawable.ic_format_header_5,
                R.drawable.ic_format_header_6,
                R.drawable.ic_format_bold,
                R.drawable.ic_format_italic,
                R.drawable.ic_format_strikethrough,
                R.drawable.ic_insert_line,
                R.drawable.ic_format_list_unordered,
                R.drawable.ic_format_list_ordered,
                R.drawable.ic_insert_image,
                R.drawable.ic_insert_link,
                R.drawable.ic_format_blockquote,
                R.drawable.ic_insert_code_single,
                R.drawable.ic_insert_code,
                R.drawable.ic_insert_table)
    }
}