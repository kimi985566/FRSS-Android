package com.ycy.markdown.View

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient

class MarkDownPreviewView : WebView {

    private var markdownString = ""

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, privateBrowsing: Boolean) : super(context, attrs, defStyleAttr, privateBrowsing) {
        init()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun init() {
        settings.javaScriptEnabled = true
        isVerticalScrollBarEnabled = false
        isHorizontalScrollBarEnabled = false
        webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                loadUrl("javascript:parseMarkdown(\"" + markdownString.replace("\n", "\\n").replace("\"", "\\\"").replace("'", "\\'") + "\")")
            }
        }
        preview("")
    }

    fun preview(markdownString: String) {
        this.markdownString = markdownString
        loadUrl("file:///android_asset/markdown.html")
    }
}
