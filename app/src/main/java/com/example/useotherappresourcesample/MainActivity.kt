package com.example.useotherappresourcesample

import android.content.pm.PackageManager
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getOtherAppString() {
        val res: Resources?
        try {
            val packageName = "com.android.settings"
            res = this.packageManager.getResourcesForApplication(packageName)
            val resourceId = res?.getIdentifier("$packageName:string/clear_activities", null, null)
            if (resourceId != null) {
                val text = this.packageManager.getText(packageName, resourceId, null)
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }

    fun onStringButtonClick(view: View) {
        getOtherAppString()
    }
}
