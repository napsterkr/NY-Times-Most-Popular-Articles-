package com.nytsample.daotest

import com.nytsample.BaseUnitTest

import com.nytsample.utils.TestCoroutineRule
import com.nytsample.data.local.dao.MostPopularDao
import com.nytsample.data.local.entity.MostPopular
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate

@RunWith(MockitoJUnitRunner::class)
    @PowerMockRunnerDelegate(JUnit4::class)
class MostPopularDaoTest : BaseUnitTest() {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var mostPopularDao: MostPopularDao
    @Before
    override fun setUp(){
        super.setUp()
        mostPopularDao=appDb.mostPopularDao()
    }
    @After
    override fun tearDown() {

    }

    @Test
    fun should_Insert_User_Item() {




            testCoroutineRule.runDispatcherTest {
                val mostPopular = MostPopular(
                    100000007403594,
                    "nyt://article/80ebc2b0-44c7-584f-bb05-0fa01ba93586",
                    "https://www.nytimes.com/2020/10/19/business/media/jeffrey-toobin-new-yorker-suspended.html",
                    100000007403594
                    ,
                    "2020-10-19",
                    "2020-10-20 14:14:48",
                    "Business",
                    "subsection","adx_keywords" ,"","By Johnny Diaz and Azi Paybarah","type","New Yorker Suspends Jeffrey Toobin After Zoom Incident","0","In a statement, the magazine said it was investigating a matter involving the author and CNN legal analyst."

               ,null,null,null,null )
                mostPopularDao.insert(mostPopular)
                val mostPopularTest = mostPopularDao.findById(mostPopular.id)
                Assert.assertEquals(mostPopular.title, mostPopularTest.title)
            }
        }





}