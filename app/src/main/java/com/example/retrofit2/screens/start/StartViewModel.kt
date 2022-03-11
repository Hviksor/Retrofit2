package com.example.retrofit2.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit2.data.repository.Repository
import com.example.retrofit2.model.nal.Nal
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel : ViewModel() {

    var repo = Repository()
    val myMoneyList: MutableLiveData<Response<Nal>> = MutableLiveData()


    fun getNalMoney() {
        viewModelScope.launch {
            myMoneyList.value = repo.getNal()
        }
    }
}