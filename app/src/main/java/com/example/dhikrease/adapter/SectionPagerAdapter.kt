package com.example.dhikrease.adapter

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dhikrease.ui.detail.article_1_fragment
import com.example.dhikrease.ui.detail.article_2_fragment
import com.example.dhikrease.ui.detail.article_3_fragment

class SectionPagerAdapter(activity: AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null
        when(position){
            0 -> fragment = article_1_fragment()
            1 -> fragment = article_2_fragment()
            2 -> fragment = article_3_fragment()
        }
        return fragment as Fragment
    }

}