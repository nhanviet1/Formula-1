package com.example.formula1.view.mainscreen.fragments.standing.teamdetail

import android.os.Bundle
import com.example.formula1.R
import com.example.formula1.databinding.ActivityTeamDetailBinding
import com.example.formula1.utils.NONE
import com.example.formula1.utils.PAGE_ONE
import com.example.formula1.utils.KEY_TEAM_ID
import com.example.formula1.utils.KEY_SEASON
import com.example.formula1.utils.KEY_CAR_URL
import com.example.formula1.utils.loadCoverImage
import com.example.formula1.utils.base.BaseActivity
import com.example.formula1.viewmodel.TeamDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailActivity :
    BaseActivity<ActivityTeamDetailBinding>(ActivityTeamDetailBinding::inflate) {

    private val viewModel: TeamDetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        setupObserve()
        getData()
    }

    private fun setup(){
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupObserve() {
        viewModel.teamDetail.observe(this@TeamDetailActivity) {
            val teamInfor = it.response?.get(NONE)
            teamInfor?.run {
                binding.textTeamName.text = name
                if (logo != null) {
                    loadCoverImage(logo, binding.imgTeamLogo)
                }
                binding.textBaseContent.text = base
                binding.textFirstEntryContent.text = firstTeamEntry.toString()
                binding.textWorldChampionshipContent.text = worldChampionships.toString()
                binding.textDirectorContent.text = director
                binding.textChasisContent.text = chassis
                binding.textEngineContent.text = engine
                binding.textTyresContent.text = tyres
                binding.textPolePositionsContent.text = polePositions.toString()
                binding.textHighestFinishRaceContent.text = highestRaceFinish?.position.toString()
            }
        }

        viewModel.driverSearchResult.observe(this@TeamDetailActivity) {
            it.response?.get(NONE)?.driver.run {
                loadCoverImage(this?.image.toString(), binding.imgDriver1)
                binding.textDriver1.text = this?.name
            }
           it.response?.get(PAGE_ONE)?.driver.run {
               loadCoverImage(this?.image.toString(), binding.imgDriver2)
               binding.textDriver2.text = this?.name
           }
        }

        viewModel.carURL.observe(this@TeamDetailActivity) {
            loadCoverImage(it, binding.imgCar)
        }
    }

    private fun getData() {
        val teamID = intent.getStringExtra(KEY_TEAM_ID)
        val season = intent.getStringExtra(KEY_SEASON)
        val carURL = intent.getIntExtra(KEY_CAR_URL, NONE)
        if (carURL != NONE) {
            viewModel.setCarImg(carURL)
        } else {
            viewModel.setCarImg(R.drawable.img_car_fer)
        }
        if (teamID != null && season != null) {
            viewModel.getTeamDetail(teamID.toInt())
            viewModel.searchDriverByTeam(teamID.toInt(), season)
        }
    }
}
