package uz.gita.newsappxmlby.presenter.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.newsappxmlby.R
import uz.gita.newsappxmlby.databinding.ScreenHomeBinding
import uz.gita.newsappxmlby.presenter.adapters.CategorizedAdapter
import uz.gita.newsappxmlby.presenter.adapters.RemoteDataAdapter
import uz.gita.newsappxmlby.presenter.viewModel.HomeViewModel
import uz.gita.newsappxmlby.presenter.viewModel.impl.HomeViewModelImpl

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
    private val viewBinding: ScreenHomeBinding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()
    private val adapterLatest: RemoteDataAdapter by lazy { RemoteDataAdapter() }
    private val adapterCategorized: CategorizedAdapter by lazy { CategorizedAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewBinding.containerCategorized.adapter = adapterCategorized
        viewBinding.containerLatest.isNestedScrollingEnabled = false

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(viewBinding.containerCategorized)
        viewBinding.containerLatest.adapter = adapterLatest

        viewModel.latest.onEach {
            if(it != null)
            adapterLatest.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.topHeadlines.onEach {
            if(it != null)
            adapterCategorized.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.categorizedHeadlines("business")

        adapterCategorized.triggerArticleClickListener {
            findNavController().navigate(MainScreenDirections.actionMainScreenToArticleScreen(it))
        }

        adapterLatest.triggerArticleClickListener {
            findNavController().navigate(MainScreenDirections.actionMainScreenToArticleScreen(it))
        }

        viewBinding.priorityChipGroup.setOnCheckedStateChangeListener { chipGroup, i ->
            val id = i[0]
            val chip = chipGroup.findViewById(id) as Chip
            when (chip.text) {
                "Technology" -> viewModel.categorizedHeadlines("technology")
                "Entertainment" -> viewModel.categorizedHeadlines("entertainment")
                "Health" -> viewModel.categorizedHeadlines("health")
                "Science" -> viewModel.categorizedHeadlines("science")
                "Sport" -> viewModel.categorizedHeadlines("sport")
                else -> viewModel.categorizedHeadlines("business")
            }
        }
    }

}

