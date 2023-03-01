package com.kkc.summonerinfo.summonGameInfo.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kkc.summonerinfo.R
import com.kkc.summonerinfo.databinding.FragmentSummonerGameInfoBinding
import com.kkc.summonerinfo.summonGameInfo.adapters.GameInfoAdapter
import com.kkc.summonerinfo.summonGameInfo.interfaces.ClickEventDelivery
import com.kkc.summonerinfo.summonGameInfo.viewModel.SummonerInfoViewModel
import com.kkc.summonerinfo.util.CustomDecoration
import com.kkc.summonerinfo.util.convertDpToPx
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SummonerInfoFragment: Fragment(), ClickEventDelivery {
    private lateinit var binding: FragmentSummonerGameInfoBinding
    private val viewModel by viewModels<SummonerInfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentSummonerGameInfoBinding>(
            layoutInflater,
            R.layout.fragment_summoner_game_info,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.totalSummonerInfo = viewModel
        gameListInit()
        viewModel.requestRefresh()
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    private fun gameListInit() {
        binding.gameInfoList.addItemDecoration(
            CustomDecoration(
                convertDpToPx(requireContext(), 4f),
                0,
                Color.TRANSPARENT,
                isTopIgnore = true
            )
        )

        binding.gameInfoList.adapter = GameInfoAdapter()

        binding.gameInfoList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                /*if (newState == SCROLL_STATE_IDLE) {
                    val layoutManager =
                        recyclerView.layoutManager as? LinearLayoutManager
                    val itemCount = (recyclerView.adapter as? GameInfoAdapter)?.itemCount ?: 0
                    val lastVisiblePosition = layoutManager?.findLastVisibleItemPosition() ?: 0

                    if (itemCount == 0 || lastVisiblePosition == 0)
                        return

                    if (lastVisiblePosition >= itemCount - 2) {
                        viewModel.requestLoadMore()
                    }
                }*/
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager =
                    recyclerView.layoutManager as? LinearLayoutManager
                val itemCount = (recyclerView.adapter as? GameInfoAdapter)?.itemCount ?: 0
                val lastVisiblePosition = layoutManager?.findLastVisibleItemPosition() ?: 0

                if (itemCount == 0 || lastVisiblePosition == 0)
                    return

                if (lastVisiblePosition >= itemCount - 2) {
                    viewModel.requestLoadMore()
                }
            }
        })

        binding.summonerInfoView.setRefreshRequestListener(this)
    }

    override fun deliveryRefreshRequestEvent() {
        viewModel.requestRefresh()
    }
}