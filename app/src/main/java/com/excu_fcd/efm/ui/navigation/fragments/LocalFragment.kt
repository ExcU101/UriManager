package com.excu_fcd.efm.ui.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.excu_fcd.efm.databinding.LocalFragmentLayoutBinding

class LocalFragment : Fragment() {

    private var binding: LocalFragmentLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LocalFragmentLayoutBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            it
            it.recycler.adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}