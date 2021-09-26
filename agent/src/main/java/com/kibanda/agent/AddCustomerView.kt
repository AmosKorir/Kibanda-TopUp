package com.kibanda.agent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kibanda.viewmodels.CustomerViewModel
import com.kibanda.agent.compents.ToolBarComponent
import com.kibanda.agent.ui.theme.KipandaTopUpTheme

class AddCustomerView {
	
	@Composable
	fun AddCustomerView(navigationController:NavHostController,customerViewModel: CustomerViewModel) {
		KipandaTopUpTheme() {
			Scaffold(
				topBar = {
					
					ToolBarComponent.ShowToolbar(stringResource(id = R.string.add_Customer),navigationController)
				},
			) {
				
				BodyContent(customerViewModel)
			}
		}
		
	}
	
	@Composable
	fun BodyContent(customerViewModel: CustomerViewModel) {
		Column(
			modifier = Modifier
				.padding(horizontal = 32.dp)
				.padding(top = 32.dp)
		) {
			
			TextField(
				value = customerViewModel.customerName.value,
				onValueChange = {
								customerViewModel.customerName.value=it
				},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(4.dp)),
				colors = TextFieldDefaults.textFieldColors(
					backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.05f),
					focusedIndicatorColor = MaterialTheme.colors.secondary,
					unfocusedIndicatorColor = Color.Transparent
				),
				
				label = { Text(text = "Customer Name") }
			)
			Spacer(modifier = Modifier.height(32.dp))
			
			TextField(
				value = customerViewModel.phone.value,
				onValueChange = {
								customerViewModel.phone.value=it
				},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(4.dp)),
				colors = TextFieldDefaults.textFieldColors(
					backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.05f),
					focusedIndicatorColor = MaterialTheme.colors.secondary,
					unfocusedIndicatorColor = Color.Transparent
				),
				label = { Text(text = "Customer phone number") }
			)
			Spacer(modifier = Modifier.height(32.dp))
			
			TextField(
				value = customerViewModel.email.value,
				onValueChange = {
								customerViewModel.email.value=it
				},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(4.dp)),
				colors = TextFieldDefaults.textFieldColors(
					backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.05f),
					focusedIndicatorColor = MaterialTheme.colors.secondary,
					unfocusedIndicatorColor = Color.Transparent
				),
				label = { Text(text = "Customer Emails") }
			)
			Spacer(modifier = Modifier.height(32.dp))
			
			Text(
				modifier = Modifier.padding(bottom = 8.dp),
				text = "Customer Location"
			)
			Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp)
			Spacer(modifier = Modifier.height(32.dp))
			Row(
				modifier = Modifier.height(80.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				
				Icon(
					painter = painterResource(id = R.drawable.ic_baseline_add_location_alt_24),
					contentDescription = ""
				)
				Spacer(modifier = Modifier.width(16.dp))
				TextField(
					value = customerViewModel.location.value,
					onValueChange = {
							customerViewModel.location.value=it
					},
					modifier = Modifier
						.fillMaxWidth()
						.clip(RoundedCornerShape(12.dp)),
					colors = TextFieldDefaults.textFieldColors(
						backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.05f),
						focusedIndicatorColor = MaterialTheme.colors.secondary,
						unfocusedIndicatorColor = Color.Transparent
					),
					label = { Text(text = "Customer location") }
				)
			}
			
			Spacer(modifier = Modifier.height(32.dp))
			
			Text(text = "Kenya")
			Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
				Button(
					modifier = Modifier
						.width(180.dp)
						.height(50.dp)
						.clip(RoundedCornerShape(12.dp)),
					onClick = {
							  customerViewModel.addCustomer()
					},
					colors = ButtonDefaults.buttonColors(
						backgroundColor = MaterialTheme.colors.primaryVariant
					
					)
				) {
					Text(text = "Create Customer")
				}
			}
		}
		if(customerViewModel.errorInput.value.isBlank()){
		
		}else{
			Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
				Text(text = customerViewModel.errorInput.value,color = Color.Red)
			}
			
		}
	}
}