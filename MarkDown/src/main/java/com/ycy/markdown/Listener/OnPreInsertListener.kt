package com.ycy.markdown.Listener


interface OnPreInsertListener {

    fun onPreInsertImage()

    fun onPreInsertLink()

    fun onPreInsertTable()
}
