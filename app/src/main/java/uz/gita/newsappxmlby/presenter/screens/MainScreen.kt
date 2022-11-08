package uz.gita.newsappxmlby.presenter.screens

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.newsappxmlby.R
import uz.gita.newsappxmlby.databinding.ScreenMainBinding
import uz.gita.newsappxmlby.presenter.adapters.MainPagerAdapter

@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {
    private val viewBinding: ScreenMainBinding by viewBinding(ScreenMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            when (viewBinding.pagerMain.currentItem) {
                0 -> {
                    val a = Intent(Intent.ACTION_MAIN)
                    a.addCategory(Intent.CATEGORY_HOME)
                    a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(a)
                }
                1 -> {
                    viewBinding.pagerMain.currentItem = 0
                }
                2 -> {
                    viewBinding.pagerMain.currentItem = 1
                }
                3 -> {
                    viewBinding.pagerMain.currentItem = 2
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewBinding.pagerMain.adapter = MainPagerAdapter(requireActivity())
        viewBinding.pagerMain.isUserInputEnabled = false

        viewBinding.bottomNavBarMain.setOnItemSelectedListener {
            viewBinding.pagerMain.setCurrentItem(
                when (it.itemId) {
                    R.id.homeScreen -> {
                        0
                    }
                    R.id.searchScreen -> {
                        1
                    }
                    R.id.bookmarkScreen -> {
                        2
                    }
//                    R.id.search_menu -> {
//                        3
//                    }
                    else -> {
                        4
                    }
                }, true
            )
            true
        }

    }


}