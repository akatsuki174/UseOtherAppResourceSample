package com.example.useotherappresourcesample

import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.custom_toast.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun showOtherAppString() {
        val res: Resources?
        try {
            val packageName = "com.android.settings"
            res = this.packageManager.getResourcesForApplication(packageName)
            val resourceId = res?.getIdentifier("clear_activities", "string", packageName)
            if (resourceId != 0 && resourceId != null) {
                val text = this.packageManager.getText(packageName, resourceId, null)
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun showOtherAppImage() {
        val res: Resources?
        try {
            val packageName = "com.hogehoge"
            res = this.packageManager.getResourcesForApplication(packageName)
            val resourceId = res?.getIdentifier("ic_launcher", "mipmap", packageName)
            val drawable = resourceId?.let { ResourcesCompat.getDrawable(res, it, null) }
            if (resourceId != 0 && resourceId != null) {
                val toast = Toast(this)
                toast.duration = Toast.LENGTH_LONG
                val layout = layoutInflater.inflate(R.layout.custom_toast, linearLayout)
                layout.customToastImage.setImageDrawable(drawable)
                toast.view = layout
                toast.show()
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }

    fun onStringButtonClick(view: View) {
        showOtherAppString()
    }

    fun onImageButtonClick(view: View) {
        showOtherAppImage()
    }
}
