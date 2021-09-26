package com.kibanda.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kibanda.domain.models.Order
import com.kibanda.domain.repositorities.OrderRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class OrderViewModel(val orderRepository: OrderRepository) : ViewModel() {
	private val compositeDisposable = CompositeDisposable()
	val handleError = mutableStateOf(Throwable())
	
	val orders = mutableStateOf(ArrayList<Order>())
	
	fun getOrders() {
		val disposable = orderRepository.getOrders()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{
					orders.value = it as ArrayList<Order>
				}, { handleError.value = it }
			)
		compositeDisposable.add(disposable)
	}
}