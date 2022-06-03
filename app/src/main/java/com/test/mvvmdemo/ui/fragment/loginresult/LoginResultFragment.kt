package com.test.mvvmdemo.ui.fragment.loginresult

import com.test.mvvmdemo.R
import com.test.mvvmdemo.databinding.FragmentLoginResultBinding
import com.test.mvvmdemo.ui.basefragment.BaseFragment

class LoginResultFragment: BaseFragment<FragmentLoginResultBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_login_result
    private val args: LoginResultFragmentArgs by lazy {
        LoginResultFragmentArgs.fromBundle(requireArguments())
    }

    override fun initView() {
        binding!!.accessToken.text= args.accessToken
        binding!!.refreshToken.text= args.refreshToken
    }
}