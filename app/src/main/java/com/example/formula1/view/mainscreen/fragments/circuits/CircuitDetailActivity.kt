package com.example.formula1.view.mainscreen.fragments.circuits

import android.os.Bundle
import com.example.formula1.databinding.ActivityCircuitDetailBinding
import com.example.formula1.utils.KEY_CIRCUIT_ID
import com.example.formula1.utils.NONE
import com.example.formula1.utils.base.BaseActivity
import com.example.formula1.utils.loadCoverImage
import com.example.formula1.viewmodel.CircuitViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CircuitDetailActivity :
    BaseActivity<ActivityCircuitDetailBinding>(ActivityCircuitDetailBinding::inflate) {

    private val viewModel: CircuitViewModel by viewModel()
    private var searchKey: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        observeData()
        getData()
    }

    private fun setup() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun observeData() {
        viewModel.searchResult.observe(this@CircuitDetailActivity) {
            it.response?.get(NONE)?.run {
                loadCoverImage(image.toString(), binding.imgCircuit)
                binding.textCircuitName.text = name
                binding.textLocationContent.text = competition.location?.country
                binding.textFirstOpenContent.text = opened.toString()
                binding.textFirstEntryContent.text = firstGrandPrix.toString()
                binding.textLapsContent.text = laps.toString()
                binding.textRaceDistanceContent.text = raceDistance.toString()
                binding.textCapacityContent.text = capacity.toString()
                binding.textDriverContent.text = lapRecord?.driver
                binding.textTimeRecordContent.text = lapRecord?.time
                binding.textYearContent.text = lapRecord?.year
            }
        }
    }

    private fun getData() {
        searchKey = intent.getStringExtra(KEY_CIRCUIT_ID)
        searchKey?.let { viewModel.searchCircuit(it) }
    }
}
