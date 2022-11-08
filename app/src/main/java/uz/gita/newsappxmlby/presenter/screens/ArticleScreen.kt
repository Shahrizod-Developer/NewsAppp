package uz.gita.newsappxmlby.presenter.screens

import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.newsappxmlby.R
import uz.gita.newsappxmlby.data.local.room.entity.ArticleEntity
import uz.gita.newsappxmlby.databinding.ScreenArticleBinding
import uz.gita.newsappxmlby.presenter.viewModel.ArticleViewModel
import uz.gita.newsappxmlby.presenter.viewModel.impl.ArticleViewModelImpl


@AndroidEntryPoint
class ArticleScreen : Fragment(R.layout.screen_article) {
    private val args: ArticleScreenArgs by navArgs()
    private val viewBinding: ScreenArticleBinding by viewBinding(ScreenArticleBinding::bind)
    private val viewModel: ArticleViewModel by viewModels<ArticleViewModelImpl>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var isBookmarked = false
        val article = args.article!!
        viewBinding.webView.loadUrl(article.url)

        viewBinding.webView.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                viewBinding.progressBar.visibility = View.GONE
            }
        })

        viewBinding.ivBack.setOnClickListener { findNavController().popBackStack() }

        viewBinding.ivBookmark.setOnClickListener {
            viewModel.bookmark(ArticleEntity(0, article))
            if (!isBookmarked) {
                viewBinding.ivBookmark.setImageResource(R.drawable.ic_baseline_bookmark_24)
                isBookmarked = true
            } else {
                viewBinding.ivBookmark.setImageResource(R.drawable.ic_baseline_bookmark_border_24)
                isBookmarked = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding.webView.destroy()
    }
}