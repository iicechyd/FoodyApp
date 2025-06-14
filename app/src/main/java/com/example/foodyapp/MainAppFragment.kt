package com.example.foodyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.foodyapp.Util.GlobalBox
import com.ismaeldivita.chipnavigation.ChipNavigationBar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainAppFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var bottomNavigation: ChipNavigationBar
    private lateinit var flWrapper: FrameLayout


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
        return inflater.inflate(R.layout.fragment_main_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigation = view.findViewById(R.id.bottom_navigation)
        GlobalBox.savedBottomNavigation = bottomNavigation
        flWrapper = view.findViewById(R.id.fl_wrapper)

        bottomNavigation.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.homePage -> {
                        replaceFragment(HomeFragment())
                    }
                    R.id.mapPage -> {
                        replaceFragment(MapFragment())
                    }
                    R.id.cartPage -> {
                        replaceFragment(CartFragment())
                    }
                    R.id.settingPage -> {
                        replaceFragment(SettingFragment())
                    }
                }
            }
        })

        // Setting default menu
        bottomNavigation.setItemSelected(R.id.homePage)
    }

    private fun replaceFragment(fragment: Fragment?) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            if (fragment != null) {
                replace(flWrapper.id, fragment)
                commit()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainAppFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainAppFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}