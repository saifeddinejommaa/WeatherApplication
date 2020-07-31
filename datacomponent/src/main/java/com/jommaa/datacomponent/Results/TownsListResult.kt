package com.jommaa.datacomponent.Results

import com.jommaa.datacomponent.dataobject.Town

sealed class TownsListResult {
    object Loading : TownsListResult()
    data class Success(val list: List<Town>) : TownsListResult()
    data class Failure(val throwable: Throwable) : TownsListResult()
}