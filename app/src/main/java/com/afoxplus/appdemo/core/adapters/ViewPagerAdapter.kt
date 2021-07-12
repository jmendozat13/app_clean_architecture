package com.afoxplus.appdemo.core.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.afoxplus.appdemo.ui.BaseFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val listFragments: List<BaseFragment>
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listFragments.size

    override fun createFragment(position: Int): Fragment = listFragments[position]

    fun getFragment(position: Int): BaseFragment = listFragments[position]

    fun deleteFragment(position: Int) = listFragments.drop(position)
}