package com.ycy.baselibrary.utils

import android.text.Editable
import android.text.TextWatcher

open class DefaultTextWatcher : TextWatcher {

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun afterTextChanged(s: Editable?) {

    }
}