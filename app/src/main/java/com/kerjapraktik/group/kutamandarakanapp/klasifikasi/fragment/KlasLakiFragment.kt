package com.kerjapraktik.group.kutamandarakanapp.klasifikasi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.adapter.DataKlasifikasiAdapter
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.KlasifikasiJk
import kotlinx.android.synthetic.main.activity_master.*
import kotlinx.android.synthetic.main.fragment_klas_laki.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ClasJkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KlasLakiFragment : Fragment(), CrudView {
    private lateinit var klasifikasi: KlasifikasiJk
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_klas_laki, container, false)
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(index: Int): KlasLakiFragment{
            val fragment = KlasLakiFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ClasJkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KlasLakiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        klasifikasi = KlasifikasiJk (this)

        var index = 1
        if (arguments != null){
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }

        klasifikasi.getDataLaki()
    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGet(data: List<DataItem>?) {
            rv_pendudukLaki.adapter = DataKlasifikasiAdapter(data)
            }

    override fun onFailedGet(msg: String) {
        TODO("Not yet implemented")

    }

    override fun onSuccessDelete(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorDelete(msg: String) {
        TODO("Not yet implemented")
    }

    override fun successAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun errordAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessUpdate(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorUpdate(msg: String) {
        TODO("Not yet implemented")
    }
}