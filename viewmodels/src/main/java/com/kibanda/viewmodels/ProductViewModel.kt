package com.kibanda.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kibanda.domain.models.Product
import com.kibanda.domain.repositorities.ProductRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {
	private val compositeDisposable = CompositeDisposable()
	val handleError = mutableStateOf(Throwable())
	val products = mutableStateOf(ArrayList<Product>())
	
	fun getProducts() {
		val disposable = productRepository.getProducts()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{
					products.value = it as ArrayList<Product>
				}, { handleError.value = it }
			)
		compositeDisposable.add(disposable)
	}
}