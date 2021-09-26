package com.kibanda.agent.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kibanda.agent.compents.ToolBarComponent
import com.kibanda.domain.models.Order
import com.kibanda.viewmodels.OrderViewModel

class OrderView {
	@Composable
	fun ShowOrders(navigationController: NavHostController, ordersViewModel: OrderViewModel) {
		Scaffold(topBar = {
			ToolBarComponent.ShowToolbar("Orders", navigationController)
		}) {
			Column(Modifier.fillMaxSize()) {
				Spacer(modifier = Modifier.height(32.dp))
				ordersViewModel.getOrders()
				LazyColumn(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 8.dp)
				) {
					items(ordersViewModel.orders.value.size) {
						OrderCard(order = ordersViewModel.orders.value[it])
					}
				}
			}
		}
	}
	
	@Composable
	fun OrderCard(order: Order) {
		Column(
			Modifier
				.padding(4.dp)
				.height(120.dp)
				.fillMaxWidth()
		) {
			Card(
				modifier = Modifier
					.padding(0.dp)
					.fillMaxSize()
			) {
				Column(Modifier.padding(16.dp)) {
					Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
						
						Text(
							text = order.customerName,
							style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal)
						)
						Text(text = order.date)
					}
					Spacer(modifier = Modifier.height(12.dp))
					Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
						Text(
							text = order.location,
							style = TextStyle(fontWeight = FontWeight.Light),
						)
						Text(
							text = order.total,
							style = TextStyle(fontWeight = FontWeight.Light),
							color = MaterialTheme.colors.primaryVariant
						)
					}
					
				}
			}
		}
	}
}