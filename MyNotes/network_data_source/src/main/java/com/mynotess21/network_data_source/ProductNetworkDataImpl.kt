package com.mynotess21.network_data_source

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.mynotess21.core.iNetwork.IProductNetworkDataSource
import com.mynotess21.core.models.Products

class ProductNetworkDataImpl() : IProductNetworkDataSource {

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("products")
    override suspend fun insertProduct(products: Products) {
        FirebaseApp.getInstance()
        val hashmap  = HashMap<String, Any>()
        products.id?.let { hashmap.put("id", it) }
        hashmap.put("productName", products.name)
        hashmap.put("price", products.price)
       hashmap.put("quantity", products.qty)

       collection.add(hashmap).addOnSuccessListener {
            Log.d("product added success", "insertProduct: ${it.id}")

        }.addOnFailureListener {
            Log.d("product added failed", "insertProduct: ${it.message}")
        }

    }

    override suspend fun updateProduct(products: Products) {

    }

    override suspend fun deleteProduct(products: Products) {
    }

    override fun getProducts(): LiveData<List<Products>> {
        TODO("Not yet implemented")
    }
}