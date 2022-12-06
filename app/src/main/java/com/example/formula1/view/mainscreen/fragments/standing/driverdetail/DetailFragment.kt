package com.example.formula1.view.mainscreen.fragments.standing.driverdetail

import com.example.formula1.R
import com.example.formula1.databinding.FragmentDetailBinding
import com.example.formula1.utils.NONE
import com.example.formula1.utils.base.BaseFragment
import com.example.formula1.utils.loadCoverImage
import com.example.formula1.viewmodel.StandingViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel: StandingViewModel by sharedViewModel()

    override fun setup() {
        //Nothing
    }

    override fun setupObservers() {
        viewModel.searchResult.observe(viewLifecycleOwner) {
            val driverInfor = it.response?.get(NONE)
            driverInfor?.run {
                binding.textBirthdayContent.text = birthdate
                binding.textBirthplaceContent.text = birthplace
                binding.textNationalityContent.text = nationality
                binding.textGrandPrixNumber.text = grandsPrixEntered.toString()
                binding.textPodiumNumber.text = podiums.toString()
                binding.textCareerPointsNumber.text = careerPoints.toString()
                binding.textHighestPositionNumber.text = highestRaceFinish?.position.toString()
            }
        }

        viewModel.carURL.observe(viewLifecycleOwner) {
            if (it != NONE) {
                context?.loadCoverImage(it, binding.imgCar)
            } else {
                context?.loadCoverImage(R.drawable.img_car_fer, binding.imgCar)
            }
        }
    }
}
