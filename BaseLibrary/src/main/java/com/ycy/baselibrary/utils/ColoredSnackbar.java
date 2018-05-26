package com.ycy.baselibrary.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

public class ColoredSnackbar {

    private static final int red = 0xfff44336;
    private static final int green = 0xff4caf50;
    private static final int blue = 0xff2195f3;
    private static final int orange = 0xffffc107;

    private static View getSnackBarLayout(Snackbar snackbar) {
        if (snackbar != null) {
            return snackbar.getView();
        }
        return null;
    }

    private static Snackbar colorSnackBar(View view, String text, int colorId) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        View snackBarView = getSnackBarLayout(snackbar);
        if (snackBarView != null) {
            snackBarView.setBackgroundColor(colorId);
        }
        return snackbar;
    }

    public static Snackbar info(View view, String text) {
        return colorSnackBar(view, text, blue);
    }

    public static Snackbar warning(View view, String text) {
        return colorSnackBar(view, text, orange);
    }

    public static Snackbar alert(View view, String text) {
        return colorSnackBar(view, text, red);
    }

    public static Snackbar confirm(View view, String text) {
        return colorSnackBar(view, text, green);
    }
}
