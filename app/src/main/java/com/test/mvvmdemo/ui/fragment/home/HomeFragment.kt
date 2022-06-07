package com.test.mvvmdemo.ui.fragment.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.test.mvvmdemo.NavMainGraphDirections
import com.test.mvvmdemo.R
import com.test.mvvmdemo.databinding.FragmentHomeBinding
import com.test.mvvmdemo.ui.basefragment.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_home
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.loginResponseLiveData.observe(this) {
            it?.let {
                findNavController().navigate(NavMainGraphDirections.actionToLoginResult(
                    it.data!!.accessToken!!,
                    it.data!!.refreshToken!!
                ))
            }
        }
    }

    override fun initView() {
        binding!!.homeVM = homeViewModel
    }

}