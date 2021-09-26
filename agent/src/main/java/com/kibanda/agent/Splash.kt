package com.kibanda.agent

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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kibanda.agent.ui.theme.KipandaTopUpTheme

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
								.background(MaterialTheme.colors.primaryVariant),
							Arrangement.Center,
							Alignment.CenterHorizontally
						) {
							Image(
								painter = painterResource(id = R.drawable.ic_launcher_foreground),
								contentDescription = ""
							)
							Text(text = "Kibanda TopUp")
							Spacer(modifier = Modifier.height(24.dp))
							Text(
								text = "Agent",
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
			startActivity(Intent(this, MainActivity::class.java))
			finish()
		}
		hander.postDelayed(runnable, 4000)
	}
}