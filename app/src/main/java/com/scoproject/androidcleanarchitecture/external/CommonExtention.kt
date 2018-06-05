package com.scoproject.androidcleanarchitecture.external

import android.content.Context
import android.net.ConnectivityManager
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.scoproject.androidcleanarchitecture.di.module.GlideApp

infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)


/**
 * Show Toast
 * */

fun Context.showToast(msg : String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

/**
 * Load Image
 * */

fun String.loadUriImage(context: Context, imageView : ImageView){
    GlideApp
            .with(context)
            .load(this)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(imageView)
}
/**
 * Show Snackbar
 * */

fun View.showSnackBar(msg :String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()
}

/**
 * Checking network state
 * @return boolean
 * */

fun Context.isNetworkConnected(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}