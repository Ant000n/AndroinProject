package android.savin.android.helloworld.ui.ntonsavin.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataAdapter = DataAdapter()
        dataAdapter.list.addAll(getTestData())
        recycler_view
    }
    private fun getTestData(): ArrayList<Data> {
        val listData = arrayListOf<Data>()
        for (i in 0..100) {
            val data = Data(i, "title $i")
            listData.add(data)

        }
        return listData
    }
}