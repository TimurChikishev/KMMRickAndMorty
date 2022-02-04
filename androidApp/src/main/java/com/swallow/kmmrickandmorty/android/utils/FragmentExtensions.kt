package com.swallow.kmmrickandmorty.android.utils

import android.content.res.Configuration
import androidx.fragment.app.Fragment

val Fragment.isOrientationPortrait: Boolean
    get() = orientation == Configuration.ORIENTATION_PORTRAIT

val Fragment.orientation: Int
    get() = resources.configuration.orientation