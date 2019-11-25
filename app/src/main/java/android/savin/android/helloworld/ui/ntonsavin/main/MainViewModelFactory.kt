package android.savin.android.helloworld.ui.ntonsavin.main

import android.savin.android.helloworld.ui.ntonsavin.repository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repos: Repository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            return MainViewModel(repos) as T
        }
        throw IllegalArgumentException()
    }
}