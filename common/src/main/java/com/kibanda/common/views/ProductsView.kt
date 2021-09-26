package com.kibanda.common.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kibanda.common.widgets.ProductCard
import com.kibanda.domain.models.Product

object ProductsView {
	@Composable
	fun ProductsView() {
		Scaffold() {
			
		}
	}
	
	@Composable
	fun ShowProducts(products: ArrayList<Product>) {
		LazyColumn(modifier = Modifier.fillMaxSize()) {
			item {
				LazyRow() {
					items(products.size){
						ProductCard.ProductCard(products[it])
					}
				}
				Spacer(modifier = Modifier.height(32.dp))
				Text(text = "Categories")
				Spacer(modifier = Modifier.height(8.dp))
				Divider()
				Spacer(modifier = Modifier.height(8.dp))
				ProductCategory(products)
				ProductCategory(products)
				ProductCategory(products)
			}
		}
	}
	
	@Composable
	fun ProductCategory(products:ArrayList<Product>) {
		Text(text = "Vegetables", color = MaterialTheme.colors.primaryVariant)
		Spacer(modifier = Modifier.height(12.dp))
		LazyRow() {
			items(products.size){
				ProductCard.ProductCard(products[it])
			}
		}
	}
	
}