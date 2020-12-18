package com.nytsample.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.nytsample.BR
import com.nytsample.R
import com.nytsample.databinding.FragmentMostPopularArticleDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class MostPopularArticleDetailsFragment : BaseFragment<FragmentMostPopularArticleDetailsBinding, MostPopularDetailsViewModel>() {
    companion object {
        fun newInstance() = MostPopularArticleDetailsFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_most_popular_article_details
    override fun provideViewModelClass(): Class<MostPopularDetailsViewModel> = MostPopularDetailsViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getUserData(arguments?.getLong("Id"))
        viewModel.onFabCLick.observe(this, Observer {
            startActivity( Intent(Intent.ACTION_VIEW, Uri.parse(it)))
        })

    }



}