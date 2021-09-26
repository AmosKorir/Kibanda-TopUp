package com.kipandatopup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kibanda.agent.ui.theme.KipandaTopUpTheme
import com.kipandatopup.R.drawable

class Splash : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			KipandaTopUpTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.primaryVariant) {
					Scaffold(modifier = Modifier.background(MaterialTheme.colors.secondary)) {
						Column(
							Modifier
								.fillMaxSize()
								.background(Color.White),
							Arrangement.Center,
							Alignment.CenterHorizontally
						) {
							Image(
								painter = painterResource(id = drawable.ic_launcher_foreground),
								contentDescription = ""
							)
							Text(text = "Kibanda",color = MaterialTheme.colors.primaryVariant,
								style = TextStyle(
									fontWeight = FontWeight.SemiBold,
									fontSize = 24.sp
								))
							Spacer(modifier = Modifier.height(24.dp))
							Text(
								text = "TopUP",
								color = MaterialTheme.colors.secondary,
								style = TextStyle(
									fontWeight = FontWeight.SemiBold,
									fontSize = 24.sp
								)
							)
						}
						
					}
				}
			}
		}
		
		//mock delay
		val hander = Handler()
		val runnable = Runnable {
			startActivity(Intent(this,LoginActivity::class.java))
			finish()
		}
		hander.postDelayed(runnable, 3000)
	}
}