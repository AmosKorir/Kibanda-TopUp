package com.loggerinterceptorformatter.data.repositories

import com.kibanda.domain.models.Order
import com.kibanda.domain.repositorities.OrderRepository
import io.reactivex.Single

class OrderApiRepository : OrderRepository {
	// mock dummy ordes
	val orders = ArrayList<Order>()
	val order1 = Order("Jane Doe", "12-04-2021", "Kisumu", "1200 sh")
	val order2 = Order("Bob Doe", "12-04-2021", "Nakuru", "1200 sh")
	val order3 = Order("Alice Doe", "12-04-2021", "Thika", "1200 sh")
	val order4 = Order("John Doe", "12-04-2021", "Umoja", "1200 sh")
	override fun getOrders(): Single<List<Order>> {
		orders.clear()
		orders.add(order1)
		orders.add(order2)
		orders.add(order3)
		orders.add(order4)
		return Single.just(orders)
	}
}