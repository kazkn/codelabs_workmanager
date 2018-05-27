package com.hoge.workmanagerapp.worker

import android.graphics.BitmapFactory
import android.util.Log
import androidx.work.Worker
import com.hoge.workmanagerapp.R

class BlurWorker() : Worker() {
    private val TAG = javaClass.kotlin.simpleName

    override fun doWork(): WorkerResult {
        return try {
            val picture = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.test)

            // Get a blurred version of the bitmap
            val blurredPicture = picture.blur()

            // Write that bitmap tot a temporary file
            val savedUri = blurredPicture.writeToFile()

            // Make a Notification displaying the URI
            makeStatusNotification(savedUri)

            WorkerResult.SUCCESS
        } catch (e: Throwable) {
            Log.e(TAG, "Error applying blur", e)
            WorkerResult.FAILURE
        }
    }
}