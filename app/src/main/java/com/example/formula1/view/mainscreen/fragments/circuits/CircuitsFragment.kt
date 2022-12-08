package com.example.formula1.view.mainscreen.fragments.circuits

import android.content.Intent
import com.example.formula1.data.model.circuitsearchitem.Response
import com.example.formula1.databinding.FragmentCircuitsBinding
import com.example.formula1.utils.KEY_CIRCUIT_ID
import com.example.formula1.utils.base.BaseFragment
import com.example.formula1.utils.gone
import com.example.formula1.utils.visible
import com.example.formula1.view.adapter.CircuitsAdapter
import com.example.formula1.viewmodel.CircuitViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CircuitsFragment : BaseFragment<FragmentCircuitsBinding>(FragmentCircuitsBinding::inflate) {

    private val circuitAdapter = CircuitsAdapter(::onClickItem)
    private val viewModel: CircuitViewModel by viewModel()

    override fun setup() {
        binding.rvCircuits.adapter = circuitAdapter
        viewModel.getCircuit()
    }

    override fun setupObservers() {
        viewModel.searchResult.observe(viewLifecycleOwner) {
            circuitAdapter.submitList(it.response)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it == true){
                binding.loadingBar.visible()
            } else {
                binding.loadingBar.gone()
            }
        }
    }

    private fun onClickItem(data: Response) {
        val intent = Intent(context, CircuitDetailActivity::class.java)
        intent.putExtra(KEY_CIRCUIT_ID, data.id.toString())
        startActivity(intent)
    }
}
