package com.example.retrofit2.screens.second

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit2.data.repository.Repository
import com.example.retrofit2.model.beznal.Beznal
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel : ViewModel() {

    val repo = Repository()
    val myPriceList: MutableLiveData<Response<Beznal>> = MutableLiveData()

    fun getBezNalPrice() {

        viewModelScope.launch {
            myPriceList.value = repo.getBezNal()
        }
    }
}