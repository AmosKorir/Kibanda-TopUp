package com.kibanda.common.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.kibanda.domain.models.Product

object ProductCard {
	
	@Composable
	fun ProductCard(product: Product) {
		Column(Modifier.padding(4.dp)) {
			Card(elevation = 1.dp) {
				Column(
					modifier = Modifier
						.width(180.dp)
						.padding(vertical = 4.dp, horizontal = 4.dp)
				) {
					Image(
						painter = rememberCoilPainter(request = product.image),
						contentDescription = "",
						modifier = Modifier
							.width(180.dp)
							.height(180.dp),
						
						contentScale = ContentScale.Crop
					)
					Spacer(modifier = Modifier.height(12.dp))
					Text(
						modifier = Modifier.fillMaxWidth(),
						text = product.name,
						style = TextStyle(fontWeight = FontWeight.Bold),
					)
					Row(
						horizontalArrangement = Arrangement.End,
						modifier = Modifier.width(200.dp)
					) {
						
						OutlinedButton(
							onClick = { },
							border = BorderStroke(1.dp, MaterialTheme.colors.primary),
							shape = RoundedCornerShape(50), // = 50% percent
							//or shape = CircleShape
							colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.primaryVariant)
						) {
							Text(text = product.price)
						}
					}
				}
			}
		}
		
	}
}