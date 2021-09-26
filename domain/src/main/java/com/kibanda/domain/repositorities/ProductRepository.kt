package com.kibanda.domain.repositorities

import com.kibanda.domain.models.Product
import io.reactivex.Single

interface ProductRepository {
	fun getProducts(): Single<List<Product>>
	
}