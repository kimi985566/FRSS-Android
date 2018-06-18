package com.ycy.markdown.View

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Pair
import android.widget.EditText

import java.util.regex.Pattern


class MarkDownEditorView : EditText {

    internal var orderPattern = Pattern.compile("^[0-9]+\\. ")

    val lastLine: String
        get() {
            val source = text.toString() + ""
            val end = source.substring(0, selectionStart).lastIndexOf('\n') + 1
            val begin = (if (end == 0) -1 else source.substring(0, end - 1).lastIndexOf('\n')) + 1
            return source.substring(begin, end)
        }

    private val lineBeginIndex: Int
        get() {
            val source = text.toString() + ""
            return source.substring(0, selectionStart).lastIndexOf('\n') + 1
        }

    private val nextLineBeginIndex: Int
        get() {
            val source = text.toString() + ""
            val nextEnter = source.indexOf('\n', selectionStart)
            return if (nextEnter == -1) source.length else nextEnter + 1
        }

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

    private fun init() {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                //新增字符
                if (i1 == 0) {
                    val str = charSequence.toString() + ""
                    //新增的是回车符
                    if (!str.isEmpty() && str[i] == '\n') {
                        val lastLine = lastLine
                        if (lastLine.startsWith("* ")) {
                            this@MarkDownEditorView.text.insert(i + 1, "* ")
                        }
                        if (lastLine.startsWith("> ")) {
                            this@MarkDownEditorView.text.insert(i + 1, "> ")
                        }
                        if (orderPattern.matcher(lastLine).lookingAt()) {
                            val num = Integer.parseInt(lastLine.substring(0, lastLine.indexOf("."))) + 1
                            this@MarkDownEditorView.text.insert(i + 1, num.toString() + ". ")
                        }
                    }
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
    }

    fun header(level: Int) {
        val newStr = "######".substring(0, level) + " "
        lineStyle(newStr)
    }

    fun insertLine() {
        val source = text.toString() + ""
        val start = selectionStart

        var newStr = "---"
        if (start == 0 || source[start - 1] != '\n')
            newStr = "\n" + newStr
        if (start == source.length || source[start] != '\n')
            newStr += "\n"
        text.insert(start, newStr)
    }

    fun bold() {
        textStyle("**")
    }

    fun italic() {
        textStyle("_")
    }

    fun strikethrough() {
        textStyle("~~")
    }

    fun unordered() {
        lineStyle("* ")
    }

    fun ordered() {
        val source = text.toString() + ""
        val begin = lineBeginIndex
        val end = nextLineBeginIndex
        var result = source.substring(begin, end)

        //取消标号
        if (orderPattern.matcher(result).lookingAt()) {
            result = result.replaceFirst("[0-9]+\\. ".toRegex(), "")
        } else {
            var num = 1
            val lastLine = lastLine
            if (orderPattern.matcher(lastLine).lookingAt()) {
                num = Integer.parseInt(lastLine.substring(0, lastLine.indexOf("."))) + 1
            }
            result = num.toString() + ". " + result
        }//添加标号
        text.replace(begin, end, result)
        setSelection(begin + result.length)
    }

    fun blockQuote() {
        lineStyle("> ")
    }

    fun codeSingle() {
        textStyle("`")
    }

    fun code() {
        textStyle("\n```\n")
    }

    fun insertImage(url: String) {
        insert("![image]($url)")
    }

    fun insertLink(info: Pair<String, String>) {
        insert("[" + info.first + "](" + info.second + ")")
    }

    fun insertTable(size: Pair<Int, Int>) {
        val end = nextLineBeginIndex
        val row = size.first
        val column = size.second

        val stringBuilder = StringBuilder()
        for (i in 0 until column) {
            stringBuilder.append("| Header ")
        }
        stringBuilder.append("|\n")
        for (i in 0 until column) {
            stringBuilder.append("|:----------:")
        }
        stringBuilder.append("|\n")
        for (i in 0 until row) {
            for (j in 0 until column) {
                stringBuilder.append("|            ")
            }
            stringBuilder.append("|\n")
        }
        val result = stringBuilder.toString()
        text.insert(end, result)
        setSelection(end + result.length)
    }

    private fun textStyle(str: String) {
        val num = str.length
        val source = text.toString() + ""
        val start = selectionStart
        val end = selectionEnd

        val result = source.substring(start, end)
        //取消样式
        if (source.substring(0, start).endsWith(str) && source.substring(end).startsWith(str)) {
            text.replace(start - num, end + num, result)
            this.setSelection(start - num, end - num)
        } else {
            text.replace(start, end, str + result + str)
            this.setSelection(start + num)
        }//添加样式
    }

    private fun lineStyle(str: String) {
        val source = text.toString() + ""
        val begin = lineBeginIndex
        val end = nextLineBeginIndex

        var result = source.substring(begin, end)

        //取消样式
        result = if (result.startsWith(str))
            result.replace(str, "")
        else
            str + result//添加样式
        text.replace(begin, end, result)
        var select = begin + result.length
        if (result.endsWith("\n"))
            select--
        setSelection(select)
    }

    private fun insert(str: String) {
        val selection = selectionStart
        text.insert(selection, str)
        setSelection(selection + str.length)
    }

}
