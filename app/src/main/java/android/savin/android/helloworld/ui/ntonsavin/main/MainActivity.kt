package android.savin.android.helloworld.ui.ntonsavin.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    lateinit var serviceintent: Intent

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
        serviceintent = Intent(this, TmsService::class.java)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                //viewModel.getString()
                startActivity(Intent(this, TmsFragmentActivity::class.java))
                //startService(intent)
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