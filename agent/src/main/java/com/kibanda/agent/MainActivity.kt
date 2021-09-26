package com.kibanda.agent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.kibanda.agent.ui.theme.KipandaTopUpTheme
import com.kibanda.agent.view.CustomerView
import com.kibanda.agent.view.MainView
import com.kibanda.agent.view.OrderView
import com.kibanda.common.NavigationRoute
import com.kibanda.viewmodels.CustomerViewModel
import com.kibanda.viewmodels.OrderViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
	val customerViewModel: CustomerViewModel by viewModel()
	val orderViewModel: OrderViewModel by viewModel()
	
	@ExperimentalAnimationApi
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			
			val scaffoldState = rememberScaffoldState()
			val scope: CoroutineScope = rememberCoroutineScope()
			val navigationController = rememberAnimatedNavController()
			
			KipandaTopUpTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					Scaffold(scaffoldState = scaffoldState) {
						Column() {
							Column {
								AnimatedNavHost(
									navController = navigationController,
									startDestination = NavigationRoute.HOME
								) {
									composable(NavigationRoute.HOME) {
										MainView.MainView(navigationController)
										
									}
									
									composable(NavigationRoute.ADD_CUSTOMER) {
										AddCustomerView().AddCustomerView(
											navigationController,
											customerViewModel
										)
									}
									
									composable(NavigationRoute.CUSTOMER_VIEW) {
										CustomerView().ShowCustomers(
											navigationController,
											customerViewModel
										)
									}
									composable(NavigationRoute.ORDERS) {
										OrderView().ShowOrders(
											navigationController = navigationController,
											ordersViewModel =orderViewModel
										)
									}
								}
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
		
		}
	}
}




