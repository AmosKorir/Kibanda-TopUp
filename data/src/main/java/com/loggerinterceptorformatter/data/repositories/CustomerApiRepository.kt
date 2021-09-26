package com.loggerinterceptorformatter.data.repositories

import com.kibanda.domain.models.Customer
import com.kibanda.domain.repositorities.CustomerRepository
import io.reactivex.Single

class CustomerApiRepository : CustomerRepository {
	// mock user data ...dummy data
	val customers = ArrayList<Customer>()
	val customer1 = Customer("John Doe", "0707389307", "john@gmail.com", "Nairobi")
	val customer2 = Customer("Mary Doe", "0727389307", "mary@gmail.com", "Kisumu")
	val customer3 = Customer("Alice Doe", "0737389307", "alice@gmail.com", "Umoja")
	val customer4 = Customer("Bob Doe", "0707380307", "bob@gmail.com", "Nairobi")
	
	override fun getCustomers(): Single<List<Customer>> {
		customers.add(customer1)
		customers.add(customer2)
		customers.add(customer3)
		customers.add(customer4)
		return Single.just(customers)
	}
	
	override fun addCustomer(
		name: String,
		phone: String,
		location: String,
		email: String
	): Single<Customer> {
		val customer = Customer(name, phone, location, email)
		customers.add(customer)
		return Single.just(customer)
	}
}