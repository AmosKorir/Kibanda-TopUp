package com.kipandatopup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.kibanda.agent.ui.theme.KipandaTopUpTheme
import com.kibanda.viewmodels.CustomerViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity() {
	val customerViewModel: CustomerViewModel by viewModel()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			KipandaTopUpTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					Scaffold() {
						Column {
							BodyContent(this@LoginActivity,customerViewModel)
						}
					}
					
				}
			}
		}
	}
	
}

@Composable
fun BodyContent(context: Context,customerViewModel: CustomerViewModel) {
	
	Box(Modifier.fillMaxSize()) {
		Column() {
			Spacer(modifier = Modifier.height(80.dp))
			Row(Modifier.fillMaxWidth(), Arrangement.Center) {
				Text(
					text = "Kibanda", color = MaterialTheme.colors.primaryVariant,
					style = TextStyle(
						fontWeight = FontWeight.SemiBold,
						fontSize = 24.sp
					)
				)
				Spacer(modifier = Modifier.height(24.dp))
				Text(
					text = " TopUp",
					color = MaterialTheme.colors.secondary,
					style = TextStyle(
						fontWeight = FontWeight.SemiBold,
						fontSize = 24.sp
					)
				)
			}
		}
		
		Column(
			modifier = Modifier
				.padding(32.dp)
				.fillMaxSize(),
			verticalArrangement = Arrangement.Center
		) {
			
			Spacer(modifier = Modifier.height(32.dp))
			Text(
				modifier = Modifier.padding(bottom = 8.dp),
				text = "Please enter your phone number"
			)
			TextField(
				value = customerViewModel.phone.value,
				onValueChange = {customerViewModel.phone.value=it},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				colors = TextFieldDefaults.textFieldColors(
					backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.05f),
					focusedIndicatorColor = MaterialTheme.colors.secondary,
					unfocusedIndicatorColor = Color.Transparent
				),
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
			)
			Spacer(modifier = Modifier.height(32.dp))
			Text(
				modifier = Modifier.padding(bottom = 8.dp),
				text = "Please enter your password"
			)
			
			TextField(
				value = customerViewModel.password.value,
				onValueChange = {customerViewModel.password.value=it},
				modifier = Modifier
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp)),
				colors = TextFieldDefaults.textFieldColors(
					backgroundColor = MaterialTheme.colors.onSurface.copy(alpha = 0.05f),
					focusedIndicatorColor = MaterialTheme.colors.secondary,
					unfocusedIndicatorColor = Color.Transparent
				),
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
			)
			
			Spacer(modifier = Modifier.height(32.dp))
			
			Button(
				modifier = Modifier
					.height(50.dp)
					.fillMaxWidth()
					.clip(RoundedCornerShape(12.dp))
					.background(Color(0xFF388E3C)),
				onClick = {
					context.startActivity(Intent(context,MainActivity::class.java))
				
				}) {
				Text(text = "Login")
			}
		}
		Text(
			modifier = Modifier
				.align(Alignment.BottomEnd)
				.padding(bottom = 32.dp)
				.padding(horizontal = 32.dp),
			text = "Don't have an account ? Please reach out to 07xx xxx xxx",
			textAlign = TextAlign.Center
		)
		
	}
	
}

@Composable
fun Greeting(name: String) {
	Text(text = "Hello $name!")
}


	
