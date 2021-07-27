package com.afoxplus.appdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), OnSetUpView, OnObserverViewModel {
    abstract fun getMainView(inflater: LayoutInflater, container: ViewGroup?): View
    override fun onSetUp() {}
    override fun onObserverViewModel() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = getMainView(inflater, container)
        onSetUp()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onObserverViewModel()
    }
}