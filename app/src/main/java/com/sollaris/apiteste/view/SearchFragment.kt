package com.sollaris.apiteste.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sollaris.apiteste.databinding.FragmentSearchBinding
import com.sollaris.apiteste.service.listener.APIListener
import com.sollaris.apiteste.service.listener.PersonListener
import com.sollaris.apiteste.view.adapter.PersonAdapter
import com.sollaris.apiteste.viewmodel.MainViewModel
import com.sollaris.apiteste.viewmodel.SearchViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null


    private lateinit var mViewModel: SearchViewModel
    private lateinit var mListener: PersonListener
    private val mAdapter = PersonAdapter()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        mViewModel.list()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun observe() {
        mViewModel.person.observe(viewLifecycleOwner, Observer {

            if (it.count() > 0) {
                mAdapter.updateListener(it)
            }

        })
    }

}