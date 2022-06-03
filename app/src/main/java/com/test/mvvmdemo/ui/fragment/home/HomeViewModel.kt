package com.test.mvvmdemo.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.jsonplaceholderapi.data.rohto.response.LoginResponse
import com.test.mvvmdemo.data.RohtoApi
import com.test.mvvmdemo.data.body.LoginUser
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val rohtoApi= RohtoApi.create()
    private val curLoginUser= LoginUser()
    val loginResponseLiveData= MutableLiveData<LoginResponse?>()

    init {
        loginResponseLiveData.value= null
    }

    fun onUserNameChange(userName:String){
        curLoginUser.userName= userName
    }

    fun onPasswordChange(password:String){
        curLoginUser.password= password
    }

    fun login()= viewModelScope.launch {
        val response= rohtoApi.login(curLoginUser)
        response?.let {
            loginResponseLiveData.value= it
        }
    }

}