package com.kibanda.agent.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kibanda.agent.R.drawable
import com.kibanda.agent.R.string
import com.kibanda.agent.ui.theme.KipandaTopUpTheme
import com.kibanda.common.NavigationRoute

object MainView {
	@Composable
	fun MainView(navigationController: NavHostController) {
		KipandaTopUpTheme() {
			Scaffold(topBar = {
				
				TopAppBar(
					title = {
						Text(
							
							text = stringResource(string.kibanda_agent),
							color = MaterialTheme.colors.secondary,
							modifier = Modifier.fillMaxWidth(),
							textAlign = TextAlign.Center
						
						)
					},
					backgroundColor = MaterialTheme.colors.surface,
					elevation = 1.dp,
					
					)
			}) {
				Column() {
					Spacer(modifier = Modifier.height(32.dp))
					BodyContent(navigationController)
				}
				
			}
		}
		
	}
	
	@Composable
	fun BodyContent(navigationController: NavHostController) {
		Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
			
			Column(
				modifier = Modifier
					.height(200.dp)
					.width(180.dp)
			) {
				Card(
					modifier = Modifier
						.fillMaxSize()
						.clickable {
							navigationController.navigate(NavigationRoute.CUSTOMER_VIEW)
						},
					elevation = 1.dp,
				) {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier.fillMaxSize()
					) {
						Spacer(modifier = Modifier.height(32.dp))
						Box(
							
							modifier = Modifier
								.size(100.dp)
								.clip(shape = CircleShape)
								.background(Color(0x38CD4C4C)),
							contentAlignment = Alignment.Center
						) {
							Icon(
								painterResource(id = drawable.ic_baseline_supervised_user_circle_24),
								contentDescription = ""
							)
						}
						Spacer(modifier = Modifier.height(32.dp))
						Text(text = "Customers")
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Column(
				modifier = Modifier
					.height(200.dp)
					.width(180.dp)
			) {
				Card(modifier = Modifier
					.fillMaxSize()
					.clickable {
						navigationController.navigate(NavigationRoute.ADD_CUSTOMER)
					}, elevation = 1.dp
				) {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier.fillMaxSize()
					) {
						Spacer(modifier = Modifier.height(32.dp))
						Box(
							
							modifier = Modifier
								.size(100.dp)
								.clip(shape = CircleShape)
								.background(Color(0x1BFF9800)),
							contentAlignment = Alignment.Center
						) {
							Icon(
								painterResource(id = drawable.ic_baseline_supervised_user_circle_24),
								contentDescription = ""
							)
						}
						Spacer(modifier = Modifier.height(32.dp))
						Text(text = "New Customer")
					}
				}
			}
		}
		
		Spacer(modifier = Modifier.height(32.dp))
		Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
			
			Column(
				modifier = Modifier
					.height(200.dp)
					.width(180.dp)
			) {
				Card(modifier = Modifier.fillMaxSize().clickable {
					navigationController.navigate(NavigationRoute.ORDERS)
				}, elevation = 1.dp) {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier.fillMaxSize()
					) {
						Spacer(modifier = Modifier.height(32.dp))
						Box(
							
							modifier = Modifier
								.size(100.dp)
								.clip(shape = CircleShape)
								.background(Color(0x724CAF50)),
							contentAlignment = Alignment.Center
						) {
							Icon(
								painterResource(id = drawable.ic_baseline_supervised_user_circle_24),
								contentDescription = ""
							)
						}
						Spacer(modifier = Modifier.height(32.dp))
						Text(text = "Orders")
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			
		}
	}
}