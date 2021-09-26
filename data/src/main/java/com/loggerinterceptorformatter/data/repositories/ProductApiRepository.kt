package com.loggerinterceptorformatter.data.repositories

import com.kibanda.domain.models.Product
import com.kibanda.domain.repositorities.ProductRepository
import io.reactivex.Single

class ProductApiRepository : ProductRepository {
	val products = ArrayList<Product>()
	val product1 = Product(
		"Pepper",
		"200-kg",
		"https://www.healthyfamiliesbc.ca/sites/hfbcprox-prod.health.gov.bc.ca/files/styles/large/public/thumbnails/raw_food_diet.jpg?itok=wZ3GS7s7"
	)
	val product2 =
		Product("Cabbage", "200-kg", "https://images.heb.com/is/image/HEBGrocery/000374791")
	val product3 = Product(
		"Greens",
		"260-kg",
		"https://image.shutterstock.com/image-photo/all-kinds-asian-vegetable-on-600w-1189465993.jpg"
	)
	val product4 = Product(
		"Potatoes",
		"50-kg",
		"https://cdn.britannica.com/89/170689-131-D20F8F0A/Potatoes.jpg"
	)
	
	override fun getProducts(): Single<List<Product>> {
		products.clear()
		products.add(product1)
		products.add(product2)
		products.add(product3)
		products.add(product4)
		return Single.just(products)
	}
}