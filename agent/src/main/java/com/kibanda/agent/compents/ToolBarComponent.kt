package com.kibanda.agent.compents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

object ToolBarComponent {
	@Composable
	fun ShowToolbar(name: String, navigationController: NavHostController) {
		TopAppBar(
			title = {
				Text(
					text = name,
					color = MaterialTheme.colors.secondary,
					modifier = Modifier.fillMaxWidth(),
					textAlign = TextAlign.Start
				
				)
			},
			backgroundColor = MaterialTheme.colors.surface,
			navigationIcon = {
				Icon(
					Icons.Default.ArrowBack,
					contentDescription = "",
					Modifier.clickable(onClick = {
						navigationController.popBackStack()
					}).height(50.dp).width(32.dp)
				)
			},
			elevation = 1.dp,
			
			)
	}
	
}