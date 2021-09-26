package com.kipandatopup.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.kipandatopup.R

class CartView {
	
	@Composable
	fun CartViewItems() {
		Scaffold(
			topBar = {
				TopAppBar(
					title = {
						Text(
							text = stringResource(R.string.cart),
							color = MaterialTheme.colors.onSecondary,
							
							)
					},
					backgroundColor = Color.White,
					elevation = 1.dp,
					navigationIcon = {
						Icon(
							Icons.Default.ArrowBack,
							contentDescription = "",
							Modifier.clickable(onClick = {
							
							})
						)
					},
					
					)
			},
			bottomBar = {
				Column(
					modifier = Modifier
						.height(150.dp)
						.fillMaxWidth()
						.padding(32.dp)
						.background(MaterialTheme.colors.background)
				) {
					Row() {
						Text(text = "Total : ")
						
						Text(
							text = "5000 ",
							style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
						)
					}
					Row(
						horizontalArrangement = Arrangement.End,
						modifier = Modifier.fillMaxWidth()
					) {
						Button(
							modifier = Modifier
								.height(50.dp)
								.width(150.dp)
								.clip(RoundedCornerShape(12.dp)),
							colors = ButtonDefaults.buttonColors(
								backgroundColor = MaterialTheme.colors.onSecondary,
								
								),
							onClick = {
//					campaign?.let {
//						campaignViewModel.payUpdate(it.id)
//					}
							
							}) {
							Text(text = "Checkout")
						}
					}
				}
			}
		) {
			LazyColumn(Modifier.padding(bottom = 150.dp)) {
				item {
					CartItem("Pepper","https://www.healthyfamiliesbc.ca/sites/hfbcprox-prod.health.gov.bc.ca/files/styles/large/public/thumbnails/raw_food_diet.jpg?itok=wZ3GS7s7")
					CartItem("Cabbage","https://images.heb.com/is/image/HEBGrocery/000374791")
					CartItem("Greens",		"https://image.shutterstock.com/image-photo/all-kinds-asian-vegetable-on-600w-1189465993.jpg")
					CartItem("Potatoes","https://cdn.britannica.com/89/170689-131-D20F8F0A/Potatoes.jpg")
				}
			}
		}
	}
	
	@Composable
	fun CartItem(name:String,image:String) {
		Row(
			modifier = Modifier
				.padding(vertical = 4.dp)
				.height(100.dp)
		) {
			Image(
				painter = rememberCoilPainter(request = image),
				contentDescription = "",
				modifier = Modifier
					.width(100.dp)
					.height(100.dp),
				contentScale = ContentScale.Crop
			)
			
			Column(
				verticalArrangement = Arrangement.Center,
				modifier = Modifier
					.fillMaxSize()
					.padding(horizontal = 32.dp)
			) {
				Row(
					horizontalArrangement = Arrangement.SpaceBetween,
					modifier = Modifier.fillMaxWidth()
				) {
					Text(text = name)
					Text(text = "200 sh")
					Icon(
						painter = painterResource(id = R.drawable.ic_baseline_close_24),
						contentDescription = ""
					)
				}
			}
		}
	}
}