package com.example.space_curiosity.components.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.space_curiosity.data.responseNasa
import com.example.space_curiosity.domain.useCaseMainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val useCaseMainActivity: useCaseMainActivity
) : ViewModel() {

    val responseInfo = MutableLiveData<responseNasa>()

    fun getInfoNasa(){
        viewModelScope.launch (Dispatchers.IO){
            responseInfo.postValue(useCaseMainActivity.queryService())
        }
    }


}