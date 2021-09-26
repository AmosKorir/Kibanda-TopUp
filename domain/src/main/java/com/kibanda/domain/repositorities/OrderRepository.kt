package com.kibanda.domain.repositorities

import com.kibanda.domain.models.Order
import io.reactivex.Single

interface OrderRepository {
	
	fun getOrders():Single<List<Order>>
	
}