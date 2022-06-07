package com.test.mvvmdemo.ui.fragment.home

import android.text.Editable
import android.util.Log
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

    fun onUserNameChange(userName:Editable){
        curLoginUser.userName= userName.toString()
        Log.d("testXml", "Username $userName")
    }

    fun onPasswordChange(password:Editable){
        Log.d("testXml", "Password $password")
    }

    fun login()= viewModelScope.launch {
        val response= rohtoApi.login(curLoginUser)
        Log.d("testApi", "Response ${response != null }")
        response?.let {
            loginResponseLiveData.value= it
        }
    }

}