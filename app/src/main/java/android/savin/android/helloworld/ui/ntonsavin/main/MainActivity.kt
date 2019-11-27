package android.savin.android.helloworld.ui.ntonsavin.main

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.savin.android.helloworld.R
import android.savin.android.helloworld.logDebag
import android.savin.android.helloworld.ui.ntonsavin.repository.RemoteRepository
import android.savin.android.helloworld.ui.ntonsavin.TmsService
import android.savin.android.helloworld.ui.ntonsavin.fragment_activity.TmsFragmentActivity
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: MainViewModel

    private var tmsService: TmsService? = null

    override fun onStart() {
        super.onStart()
        logDebag("onStart")
        viewModel = ViewModelProviders
            .of(this, MainViewModelFactory(RemoteRepository()))
            .get(MainViewModel::class.java)

        viewModel.data.observe(this, observer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logDebag("onCreate")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container.ListFragment())
            .commit()
       // serviceintent = Intent(this, TmsService::class.java)
        //button.setOnClickListener(this)
       // startService(intent)
        //bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private val serviceConnection = object:ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            name.toString()
           }
    }
    fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        val binder = service as TmsService.LocalBinder
        tmsService = binder.service
        tmsService?.todo()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                try {
                    unbindService(serviceConnection)
                }catch (e:Exception) {
                    e.message?.let {
                        logDebag(it)
                    }
                }

            }

            R.id.text -> {
                button.setText("Hello2154")
            }
        }
    }

    private val observer = Observer<String> {
        text.text = it
    }

    override fun onDestroy() {
        super.onDestroy()
        logDebag("onDestroy")
        stopService(serviceintent)
    }
}