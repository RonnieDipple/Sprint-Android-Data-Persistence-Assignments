package com.example.roomsqllite.database.helpers_threads

import android.os.Handler
import android.os.HandlerThread

// This handles background threads it is my worker :) I know I am using Handler and
// yes I know it is not AsyncTask but I like the freedom of Handler
class DatabaseWorker(threadName: String): HandlerThread(threadName) {
    private lateinit var handler: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        handler = Handler(looper)
    }

    fun postTask(task: Runnable){
        handler.post(task)

    }
}