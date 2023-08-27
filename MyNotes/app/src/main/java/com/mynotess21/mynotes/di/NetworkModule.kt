package com.mynotess21.mynotes.di

import com.mynotess21.core.iNetwork.IProductNetworkDataSource
import com.mynotess21.network_data_source.ProductNetworkDataImpl
import org.koin.dsl.module

val networkModule = module {
    factory<IProductNetworkDataSource> { ProductNetworkDataImpl() }
}