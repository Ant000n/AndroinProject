package android.savin.android.helloworld.ui.ntonsavin

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.os.Binder
import java.lang.Math.log


class TmsService : IntentService("TmsService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("TmsService","onHandleIntent")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    private val mBinder = LocalBinder()

    inner class LocalBinder : Binder() {
        internal// Return this instance of LocalService so clients can call public methods
        val service: TmsService = this@TmsService
    }
    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    fun todo() {
        Log.d("TmsService", "todo")
    }
    override fun onCreate() {
        super.onCreate()
        Log.d("TmsService", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TmsService", "onDestroy")
    }
}