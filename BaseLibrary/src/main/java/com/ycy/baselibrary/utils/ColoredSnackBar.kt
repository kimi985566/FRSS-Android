package com.ycy.baselibrary.utils

import android.support.design.widget.Snackbar
import android.view.View

object ColoredSnackBar {

    private val red = -0xbbcca
    private val green = -0xb350b0
    private val blue = -0xde6a0d
    private val orange = -0x3ef9

    private fun getSnackBarLayout(snackBar: Snackbar?): View? {
        return snackBar?.view
    }

    private fun colorSnackBar(view: View, text: String, colorId: Int): Snackbar {
        val snackBar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
        val snackBarView = getSnackBarLayout(snackBar)
        snackBarView?.setBackgroundColor(colorId)
        return snackBar
    }

    fun info(view: View, text: String): Snackbar {
        return colorSnackBar(view, text, blue)
    }

    fun warning(view: View, text: String): Snackbar {
        return colorSnackBar(view, text, orange)
    }

    fun alert(view: View, text: String): Snackbar {
        return colorSnackBar(view, text, red)
    }

    fun confirm(view: View, text: String): Snackbar {
        return colorSnackBar(view, text, green)
    }
}
