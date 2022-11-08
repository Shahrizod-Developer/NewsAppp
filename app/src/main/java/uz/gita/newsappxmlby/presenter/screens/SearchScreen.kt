package uz.gita.newsappxmlby.presenter.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.gita.newsappxmlby.R
import uz.gita.newsappxmlby.databinding.ScreenSearchBinding
import uz.gita.newsappxmlby.presenter.adapters.RemoteDataAdapter
import uz.gita.newsappxmlby.presenter.viewModel.SearchViewModel
import uz.gita.newsappxmlby.presenter.viewModel.impl.SearchViewModelImpl

@AndroidEntryPoint
class SearchScreen : Fragment(R.layout.screen_search) {
    private val viewModel: SearchViewModel by viewModels<SearchViewModelImpl>()
    private val viewBinding: ScreenSearchBinding by viewBinding(ScreenSearchBinding::bind)
    private val adapter: RemoteDataAdapter by lazy { RemoteDataAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.searchContainer.adapter = adapter

        viewModel.searchFlow.onEach {
            adapter.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.searchNews(search = query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    delay(250)
                    if (newText != null) {
                        Log.d("zzzz","$newText")
//                        viewModel.searchNews(search = newText)
                    }

                }
                return true
            }
        })

        adapter.triggerArticleClickListener {
            findNavController().navigate(MainScreenDirections.actionMainScreenToArticleScreen(it))
        }
    }
}