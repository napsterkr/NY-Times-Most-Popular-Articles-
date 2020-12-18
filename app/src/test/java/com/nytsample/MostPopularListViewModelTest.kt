package com.nytsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.remote.api.IMostPopularApi
import com.nytsample.data.repository.MostPopularRepository
import com.nytsample.presentation.ui.MostPopularListViewModel
import com.nytsample.utils.MockResponse
import com.nytsample.utils.TestCoroutineRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
@PowerMockRunnerDelegate(JUnit4::class)
class MostPopularListViewModelTest: BaseUnitTest() {
    //It will tell JUnit to force tests to be executed synchronously, especially when using Architecture Components.
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()
    private lateinit var iMostPopularApi: IMostPopularApi
    private lateinit var viewModel: MostPopularListViewModel
    private lateinit var mostPopularRepository: MostPopularRepository
    private lateinit var mostPopularDao: MostPopularDao

    @Before
    override fun setUp(){
        super.setUp()

        iMostPopularApi = apiModule.provideMostPopularApi(retrofit = retrofit)
        mostPopularDao=appDb.mostPopularDao()
        mostPopularRepository = repositoryModule.provideMostPopularRepository(iMostPopularApi,mostPopularDao)
        viewModel = MostPopularListViewModel(mostPopularRepository,mostPopularDao)

    }

    @Test
    fun testFetchGitUserSuccess(){
        testCoroutineRule.runBlockingTest {


            mockWebServer.enqueue(
                MockResponse.createMockResponse(
                    "get_most_popular_list_success",
                    HttpURLConnection.HTTP_OK
                )
            )
            Assert.assertNotNull(viewModel.getUserListData())
//            Assert.assertNull("error")
        }
        }
@Test
fun testFetchGitUsersFail(){
    testCoroutineRule.runBlockingTest {
        Assert.assertNotNull(viewModel.errorString.postValue("Unknown error message"))
    }
}
}