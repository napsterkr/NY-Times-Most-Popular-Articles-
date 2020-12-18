package com.nytsample.presentation.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    abstract fun provideViewModelClass(): Class<VM>
    abstract fun layoutId(): Int
    abstract val bindingVariable: Int


    private lateinit var viewBinding: VB
    protected lateinit var viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this).get(provideViewModelClass())
        onInitLabels()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(layoutId(), container, false)
        viewBinding = DataBindingUtil.bind(view)!!
        viewBinding.lifecycleOwner = this
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.setVariable(bindingVariable, viewModel)
        viewBinding.executePendingBindings()
    }

    /**
     * Method call to initialize the remote config in View Model
     */
    open fun onInitLabels() {
        viewModel.initConfig()
    }




}