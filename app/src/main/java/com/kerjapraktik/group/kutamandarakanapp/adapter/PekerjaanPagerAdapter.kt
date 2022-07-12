package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.*

class PekerjaanPagerAdapter (val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(
        R.string.tab_karyawan,
        R.string.tab_petani,
        R.string.tab_guru,
        R.string.tab_pns,
        R.string.tab_wiraswasta
    )

    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = KlasKaryawanFragment()
            1 -> fragment = KlasPetaniFragment()
            2 -> fragment = KlasGuruFragment()
            3 -> fragment = KlasPnsFragment()
            4 -> fragment = KlasWiraswastaFragment()
        }

        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }
}