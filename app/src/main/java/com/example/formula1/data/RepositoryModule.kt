package com.example.formula1.data

import com.example.formula1.data.repository.SearchRepository
import com.example.formula1.data.repository.SearchRepositoryImplement
import com.example.formula1.data.source.SearchDataSource
import org.koin.dsl.module

val RepositoryModule = module {
    single { provideSearchRepository(get()) }
}

fun provideSearchRepository(remote: SearchDataSource.Remote): SearchRepository {
    return SearchRepositoryImplement(remote)
}
