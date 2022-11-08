package uz.gita.newsappxmlby.presenter.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.newsappxmlby.presenter.screens.BookmarkScreen
import uz.gita.newsappxmlby.presenter.screens.HomeScreen
import uz.gita.newsappxmlby.presenter.screens.SearchScreen

class MainPagerAdapter(f: FragmentActivity) : FragmentStateAdapter(f) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeScreen()
            }
            1 -> {
                SearchScreen()
            }
            else -> {
                BookmarkScreen()
            }
        }
    }
}