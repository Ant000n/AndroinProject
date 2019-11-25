package android.savin.android.helloworld.ui.ntonsavin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TmsService: Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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