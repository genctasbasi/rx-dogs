package com.genctasbasi.rxdogs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.genctasbasi.rxdogs.R
import com.genctasbasi.rxdogs.navigation.NavigationManager
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val navigationManager: NavigationManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        just_operator_button.setOnClickListener {
            navigationManager.navigateTo(MainFragmentDirections.actionMainFragmentToDetailsFragment())
        }
    }
}