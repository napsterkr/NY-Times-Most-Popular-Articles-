package com.nytsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule

import com.nytsample.utils.TestCoroutineRule
import com.nytsample.BaseUnitTest
import com.nytsample.presentation.ui.MostPopularDetailsViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate

@RunWith(MockitoJUnitRunner::class)
@PowerMockRunnerDelegate(JUnit4::class)
class MostPopularDetailsViewModelTest: BaseUnitTest() {
    //It will tell JUnit to force tests to be executed synchronously, especially when using Architecture Components.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: MostPopularDetailsViewModel

    @Before
    override fun setUp(){
        super.setUp()
        viewModel = MostPopularDetailsViewModel(appDb.mostPopularDao())

    }

    @Test
    fun testFetchUserSuccess(){
    testCoroutineRule.runDispatcherTest {
      viewModel.getUserData(100000007403594)}
    }

}