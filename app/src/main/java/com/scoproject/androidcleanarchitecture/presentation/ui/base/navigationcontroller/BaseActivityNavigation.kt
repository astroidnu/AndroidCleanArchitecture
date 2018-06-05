package com.scoproject.androidcleanarchitecture.presentation.ui.base.navigationcontroller

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by ibnumuzzakkir on 06/06/18.
 * Mobile Engineer
 */

open class BaseActivityNavigation {
    /**
     * Intent Common Function
     * Handling new intent
     * */

    fun <T> newIntent(context: Context, cls: Class<T>): Intent {
        return Intent(context, cls)
    }

    fun newIntentUri(label: String, uri: Uri): Intent {
        return Intent(label, uri)
    }
}