package com.kibanda.domain.models

data class Order(
	val customerName: String,
	val date: String,
	val location: String,
	val total: String
)
