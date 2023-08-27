package com.mynotess21.mynotes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.mynotess21.core.iService.IProductService
import com.mynotess21.core.models.Note
import com.mynotess21.core.models.Products
import kotlinx.coroutines.launch

class ProductViewModel(private val iProductService: IProductService) : ViewModel() {
    val _pname:MutableLiveData<String> = MutableLiveData("")
//    val pname : LiveData<String>
//        get() = _pname

    val _price=MutableLiveData<Int>()
//    val price : LiveData<Double>
//        get() = _price

    private val _productId=MutableLiveData<String?>()
    val productId : LiveData<String?>
        get() = _productId

    val _qty=MutableLiveData<Int>()
//    val qty : LiveData<Int>
//        get() = _qty

    private val _image=MutableLiveData<String>()
    val image : LiveData<String>
        get() = _image

    private val _message=MutableLiveData<String>("")
    val message : LiveData<String>
        get() = _message

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("products")
    init {

    }

    fun insertProduct(){
        if(_pname.value.isNullOrEmpty()){
            _message.value="Name is required!"
            return
        }
        if((_price.value==null) or (_price.value==0)){
            _message.value="Invalid price!"
            return
        }
        if ((_qty.value==null)or(_qty.value==0)){
            _message.value="Invalid Quantity"
            return
        }
        else{
            val name = _pname.value
            val product = name?.let {
                _price.value?.let { it1 ->
                    _qty.value?.let { it2 ->
                        Products(collection.document().toString(),
                            it, it1, it2
                        )
                    }
                }
            }

            viewModelScope.launch {
                if (product != null) {
                    iProductService.insertProduct(product)
                    _message.value="Product added successfully!"

                }
            }
        }

    }

    fun setArguments(products: Products){
        _productId.value = products.id
        _pname.value = products.name
        _price.value = products.price
        _qty.value = products.qty?.toInt()


    }
    fun emptyMessage(){
        _message.value = ""
    }
}