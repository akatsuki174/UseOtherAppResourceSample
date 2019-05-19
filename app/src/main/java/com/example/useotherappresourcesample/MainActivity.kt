package com.example.useotherappresourcesample

import android.content.pm.PackageManager
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getOtherAppString()
    }

    private fun getOtherAppString() {
        val res: Resources?
        try {
            res = this.packageManager.getResourcesForApplication(packageName)
            val packageName = "com.android.settings"
            val resourceId = res?.getIdentifier("$packageName:string/clear_activities", null, null)
            if (resourceId != 0 && resourceId != null) {
                val text = this.packageManager.getText(packageName, resourceId, null)
                Log.i("other_app_resource", "resource=$text")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }
}
