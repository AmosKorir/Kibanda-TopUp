package com.kibanda.agent.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kibanda.agent.R
import com.kibanda.agent.compents.ToolBarComponent
import com.kibanda.domain.models.Customer
import com.kibanda.viewmodels.CustomerViewModel

class CustomerView {
	@Composable
	fun ShowCustomers(
		navigationController: NavHostController,
		customerViewModel: CustomerViewModel
	) {
		customerViewModel.getCustomers()
		Scaffold(
			topBar = {
				ToolBarComponent.ShowToolbar(
					name = "Customers",
					navigationController = navigationController
				)
			}
		) {
			Spacer(modifier = Modifier.height(32.dp))
			LazyColumn(Modifier.fillMaxSize()) {
				items(customerViewModel.customers.value.size) {
					val customer = customerViewModel.customers.value[it]
					CustomerCard(customer, navigationController)
				}
			}
		}
		
	}
	
	@Composable
	fun CustomerCard(customer: Customer, navigationController: NavHostController) {
		Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),verticalArrangement =Arrangement.Center) {
			Card(
				modifier = Modifier
					.height(150.dp)
					.fillMaxWidth(),
				elevation = 1.dp
			) {
				Row(Modifier.fillMaxSize(),Arrangement.Center) {
					Column(modifier = Modifier
						.fillMaxHeight()
						.width(100.dp),
						horizontalAlignment = Alignment.CenterHorizontally,
						verticalArrangement = Arrangement.Center
					) {
						Image(
							painter = painterResource(id = R.drawable.user),
							contentDescription = "",
							contentScale = ContentScale.Inside,
							modifier = Modifier
								.height(50.dp)
								.width(50.dp)
						)
					}
					
					Column(Modifier.fillMaxWidth()) {
						Spacer(modifier = Modifier.height(32.dp))
						Text(text = customer.name, fontWeight = FontWeight.SemiBold)
						Spacer(modifier = Modifier.height(4.dp))
						Row(Modifier.fillMaxWidth()) {
							Icon(
								painter = painterResource(id = R.drawable.ic_baseline_add_location_alt_24),
								contentDescription = "",
								Modifier.clickable(onClick = {
								}),
								tint = Color.Gray
							)
							Text(text = customer.location)
							Spacer(modifier = Modifier.width(12.dp))
							Text(text = customer.phone)
						}
						Text(
							modifier = Modifier.padding(horizontal = 4.dp),
							text = customer.email,
							style = TextStyle(fontWeight = FontWeight.Light)
						)
					}
				}
			}
			
		}
	}
}