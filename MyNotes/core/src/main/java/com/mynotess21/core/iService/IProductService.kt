package com.mynotess21.core.iService

import androidx.lifecycle.LiveData
import com.mynotess21.core.models.Products

interface IProductService {

    suspend fun insertProduct(products: Products)

    suspend fun updateProduct(products: Products)

    suspend fun deleteProduct(products: Products)

    fun getProducts(): LiveData<List<Products>>
}