package com.dev_ankur.infoappmvvm.viewModel

import com.example.assignmentpw.models.ResultS
import com.example.assignmentpw.models.RikaMortyList
import com.dev_ankur.infoappmvvm.utils.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getRikaMorty(page:Int): Response<RikaMortyList>{
        return RetrofitInstance.api.getRickData(page)
    }

    suspend fun getRikaDetail(id:Int): Response<ResultS>{
        return RetrofitInstance.api.getRickaDetail(id = id)
    }


}