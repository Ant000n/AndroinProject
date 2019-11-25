package android.savin.android.helloworld.ui.ntonsavin.fragment

import android.content.Intent
import android.os.Bundle
import android.savin.android.helloworld.R
import android.savin.android.helloworld.ui.ntonsavin.TmsService
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tms.*

class TmsFragment : Fragment() {

    companion object {
        
        fun getInstance(string: String): TmsFragment{
            val bundle =  Bundle()
            bundle.putString("key", string)
            val fr = TmsFragment()
            fr.arguments = bundle
            return fr
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arg = arguments
        val str = arg?.getString("key")
        textTms.text = str

        textTms2.setOnClickListener {
            val intent = Intent(activity, TmsService::class.java)
            intent.putExtra("key", "value")
            activity?.startService(intent)
        }

        textTms.setOnClickListener {
            Toast.makeText(context,"TmsFragment", Toast.LENGTH_SHORT).show()
        }
    }
}