package com.hoge.workmanagerapp.ui.main

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableField
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.hoge.workmanagerapp.R
import com.hoge.workmanagerapp.worker.BlurWorker

class MainViewModel : ViewModel() {
    enum class BlurLevel {
        Little,
        More,
        Most
    }

    var image: ObservableField<Bitmap> = ObservableField()
    var blurLevel = BlurLevel.Little

    private val workManager = WorkManager.getInstance()

    fun loadPhoto(context: Context) {
        image.set(BitmapFactory.decodeResource(context.resources, R.drawable.test))
    }

    fun applyBlur() {
        workManager.enqueue(OneTimeWorkRequest.from(BlurWorker::class.java))
    }
}
