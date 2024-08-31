package com.dev_ankur.infoappmvvm.domain

import com.example.assignmentpw.models.ResultS
import com.example.assignmentpw.models.RikaMortyList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/api/character")
    suspend fun getRickData(
        @Query("page")page: Int
    ):Response<RikaMortyList>


    @GET("/api/character/{id}")
    suspend fun getRickaDetail(
        @Path("id")id: Int
    ):Response<ResultS>

}