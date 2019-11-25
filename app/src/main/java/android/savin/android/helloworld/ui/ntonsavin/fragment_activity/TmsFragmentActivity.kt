package android.savin.android.helloworld.ui.ntonsavin.fragment_activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.savin.android.helloworld.R
import android.savin.android.helloworld.ui.ntonsavin.fragment.TmsFragment

class TmsFragmentActivity : AppCompatActivity() {

    lateinit var br: TmsBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tms_fragment)
        setTitle("TmsFragmentActivity")
        br = TmsBroadcastReceiver()
        registerReceiver(br, TmsBroadcastReceiver.getIntentFilter())

        val fr = TmsFragment.getInstance("value")

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fr)
            .commit()
    }


    class TmsBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            val ex = p1?.hasExtra("key2")
        }

        companion object {

            public fun getIntentFilter(): IntentFilter {
                val filter = IntentFilter()
                filter.addCategory("defaulf")
                filter.addAction("tms")
                return filter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
}
