package com.andersmurillo92.posts.views.base

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.andersmurillo92.posts.R

open class BaseActivity: AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

    fun showProgressDialog(title: String?, message: String, indeterminate: Boolean, cancelable: Boolean){
        progressDialog = ProgressDialog.show(this@BaseActivity, title, message, indeterminate, cancelable)
    }

    fun hideProgressDialog() {
        if(progressDialog.isShowing)
            progressDialog.dismiss()
    }

    fun isOnline(): Boolean {
        var result = false
        val connMgr = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected)
            result = true
        return result
    }

    fun showAlert(message: String){
        val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(R.string.error_title)
        alertDialog.setMessage(message)
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, getString(R.string.OK)
        ) { dialog, _ -> dialog.dismiss() }
        alertDialog.show()
    }
}