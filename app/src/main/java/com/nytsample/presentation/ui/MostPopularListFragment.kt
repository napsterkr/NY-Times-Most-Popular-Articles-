package com.nytsample.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.nytsample.BR
import com.nytsample.R
import com.nytsample.databinding.FragmentMostPopularListBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class MostPopularListFragment:  BaseFragment<FragmentMostPopularListBinding, MostPopularListViewModel>() {
    companion object {
        fun newInstance() = MostPopularListFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_most_popular_list
    override fun provideViewModelClass(): Class<MostPopularListViewModel> = MostPopularListViewModel::class.java

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData(7)
        viewModel.id.observe(viewLifecycleOwner, Observer {
            navigateToUserDetails(it)

        })
viewModel.responseData.observe(viewLifecycleOwner, Observer {
    it?.let {
        viewModel.uiHandler(it)

    }


})
    }

 private fun  navigateToUserDetails(id:Long){
        val arg=Bundle()
        arg.putLong("Id",id)
        val fragment=MostPopularArticleDetailsFragment.newInstance()
        fragment.arguments=arg
        activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)
            ?.add(R.id.container, fragment)?.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.daily -> viewModel.getData(1)
            R.id.weekly -> viewModel.getData(7)
            R.id.monthly -> viewModel.getData(30)
        }
        return true
    }
}