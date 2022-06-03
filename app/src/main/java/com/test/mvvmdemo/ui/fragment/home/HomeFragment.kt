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
        binding!!.edtUserName.addTextChangedListener(provideTextWatcher {
            homeViewModel.onUserNameChange(it)
        })
        binding!!.edtUserName.addTextChangedListener(
            provideTextWatcher {
                homeViewModel.onPasswordChange(it)
            }
        )
        binding!!.homeVM = homeViewModel
    }

    private fun provideTextWatcher(onchange: (String) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    onchange(it.toString())
                }
            }
        }
    }
}