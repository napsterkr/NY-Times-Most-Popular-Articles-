package com.nytsample.data.repository

import com.nytsample.data.common.ResultState
import com.nytsample.data.config.Entity
import com.nytsample.data.config.NetworkConstant
import java.net.ConnectException
import java.net.UnknownHostException


abstract class BaseRepositoryImpl {
    private val logFormatter: String = "%s | %s"
    internal fun handleErrorReturn(throwable: Throwable): ResultState.Error<ResultState<List<Entity.Error>>> {
        return when (throwable) {


            is ConnectException, is UnknownHostException -> {
                ResultState.Error(
                    throwable,
                    Entity.ErrorEntity(
                        listOf(
                            Entity.Error(
                                NetworkConstant.RESPONSE_CODE_GENERAL_NETWORK_ERROR.toString(),
                                NetworkConstant.ERROR_MESSAGE_GENERAL_NETWORK
                            )
                        )
                    )
                )
            }




            else -> {
                ResultState.Error(
                    throwable,
                    Entity.ErrorEntity(
                        listOf(
                            Entity.Error(
                                NetworkConstant.RESPONSE_CODE_UNEXPECTED.toString(),
                                NetworkConstant.ERROR_MESSAGE_UNEXPECTED
                            )
                        )
                    )
                )
            }
        }
    }




}