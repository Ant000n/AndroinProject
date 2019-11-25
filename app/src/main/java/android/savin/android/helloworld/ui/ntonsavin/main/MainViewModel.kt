package android.savin.android.helloworld.ui.ntonsavin.main

import android.savin.android.helloworld.ui.ntonsavin.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repo: Repository) : ViewModel() {

    var data = MutableLiveData<String>()

    fun getString() {
        data.value = repo.getData()
    }
}