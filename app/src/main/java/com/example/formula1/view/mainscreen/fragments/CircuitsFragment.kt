package com.example.formula1.view.mainscreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.formula1.databinding.FragmentCircuitsBinding

class CircuitsFragment : Fragment() {
    private val binding by lazy { FragmentCircuitsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
