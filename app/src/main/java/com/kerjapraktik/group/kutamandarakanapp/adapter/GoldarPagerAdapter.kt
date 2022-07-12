package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasGoldarABFragment
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasGoldarAFragment
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasGoldarBFragment
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment.KlasGoldarOFragment

class GoldarPagerAdapter (val mContext: Context, fm:FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private val TAB_TITLES = intArrayOf(R.string.tab_goldara, R.string.tab_goldarab, R.string.tab_goldarb, R.string.tab_goldaro)
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = KlasGoldarAFragment()
            1 -> fragment = KlasGoldarABFragment()
            2 -> fragment = KlasGoldarBFragment()
            3 -> fragment = KlasGoldarOFragment()
        }

        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }
}