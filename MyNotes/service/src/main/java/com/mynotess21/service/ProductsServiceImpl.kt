package com.mynotess21.service

import androidx.lifecycle.LiveData
import com.mynotess21.core.iNetwork.IProductNetworkDataSource
import com.mynotess21.core.iService.IProductService
import com.mynotess21.core.models.Products

class ProductsServiceImpl(private val productNetworkData: IProductNetworkDataSource) : IProductService {
    override suspend fun insertProduct(products: Products) {
        productNetworkData.insertProduct(products)
    }

    override suspend fun updateProduct(products: Products) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(products: Products) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): LiveData<List<Products>> {
        TODO("Not yet implemented")
    }
}