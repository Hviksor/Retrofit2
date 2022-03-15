package com.example.retrofit2.screens.second

import androidx.lifecycle.*
import com.example.retrofit2.data.repository.Repository
import com.example.retrofit2.model.beznal.Beznal
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel : ViewModel() {
    val repo = Repository()
    val myBezNalMoneyList: MutableLiveData<Response<Beznal>> = MutableLiveData()

    fun getBezNalMoney() {
        viewModelScope.launch {
            myBezNalMoneyList.value = repo.getBezNallCourse()
        }

    }
}