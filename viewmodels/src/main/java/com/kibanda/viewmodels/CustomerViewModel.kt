package com.kibanda.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kibanda.domain.models.Customer
import com.kibanda.domain.repositorities.CustomerRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CustomerViewModel(private val customerRepository: CustomerRepository) : ViewModel() {
	
	private val compositeDisposable = CompositeDisposable()
	val handleError = mutableStateOf(Throwable())
	
	val customers = mutableStateOf(ArrayList<Customer>())
	
	fun getCustomers() {
		val disposable = customerRepository.getCustomers()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{
					customers.value = it as ArrayList<Customer>
				}, { handleError.value = it }
			)
		compositeDisposable.add(disposable)
	}
	
	/**
	 * Add Customer
	 */
	
	val customerName = mutableStateOf("")
	val phone = mutableStateOf("")
	val email = mutableStateOf("")
	val location = mutableStateOf("")
	val password= mutableStateOf("")
	val errorInput = mutableStateOf("")
	
	fun addCustomer() {
		var error = false
		
		if (customerName.value.isEmpty()) {
			error = true
		}
		if (phone.value.isEmpty()) {
			error = true
		}
		if (email.value.isEmpty()) {
			error = true
		}
		if (location.value.isEmpty()) {
			error = true
		}
		
		if (error) {
			errorInput.value = "Please fill all fields"
		} else {
			errorInput.value = ""
			val disposable = customerRepository.addCustomer(
				customerName.value,
				phone.value,
				email.value,
				location.value
				
			)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
					{
						customerName.value = ""
						phone.value = ""
						email.value = ""
						location.value = ""
					}, { handleError.value = it }
				)
			compositeDisposable.add(disposable)
		}
		
	}
}