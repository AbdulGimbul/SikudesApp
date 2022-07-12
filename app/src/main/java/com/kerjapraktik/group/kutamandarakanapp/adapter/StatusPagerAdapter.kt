package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasCeraiFragment
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasCeraiMatiFragment
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasLajangFragment
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasMenikahFragment

class StatusPagerAdapter (private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_lajang, R.string.tab_menikah, R.string.tab_cerai, R.string.tab_cerai_mati)

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position){
            0 -> fragment = KlasLajangFragment()
            1 -> fragment = KlasMenikahFragment()
            2 -> fragment = KlasCeraiFragment()
            3 -> fragment = KlasCeraiMatiFragment()
        }
        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

}