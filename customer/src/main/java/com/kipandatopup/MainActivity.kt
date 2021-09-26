package com.kipandatopup

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kibanda.common.views.ProductsView
import com.kibanda.viewmodels.ProductViewModel
import com.kipandatopup.R.drawable
import com.kipandatopup.ui.theme.KipandaTopUpTheme
import com.kipandatopup.views.CartView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
	private val productViewModel: ProductViewModel by viewModel()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		productViewModel.getProducts()
		setContent {
			KipandaTopUpTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					Scaffold(
						topBar = {
							TopAppBar(
								actions = {
									IconButton(onClick = {
										startActivity(
											Intent(
												this@MainActivity,
												CartActivity::class.java
											)
										)
									}) {
										Icon(
											
											painterResource(id = drawable.ic_baseline_shopping_cart_24),
											contentDescription = "",
											tint = MaterialTheme.colors.secondary
										)
									}
								},
								title = {
									Row() {
										Text(
											text = "Kibanda",
											color = MaterialTheme.colors.primaryVariant
										)
										Text(
											text = "  TopUp",
											color = MaterialTheme.colors.secondary
										)
										
									}
									
								},
								backgroundColor = MaterialTheme.colors.surface,
								elevation = 1.dp
							)
						},
					) {
						Column(Modifier.padding(8.dp)) {
							Spacer(modifier = Modifier.height(32.dp))
							Text(text = "Top Products")
							Spacer(modifier = Modifier.height(16.dp))
							ProductsView.ShowProducts(productViewModel.products.value)
						}
					}
				}
				
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	KipandaTopUpTheme {
		CartView().CartViewItems()
	}
}