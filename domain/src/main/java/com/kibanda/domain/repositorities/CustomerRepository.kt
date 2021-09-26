package com.kibanda.domain.repositorities

import com.kibanda.domain.models.Customer
import io.reactivex.Single

interface CustomerRepository {
	fun getCustomers(): Single<List<Customer>>
	fun addCustomer(name: String, phone: String, location: String, email: String): Single<Customer>
}