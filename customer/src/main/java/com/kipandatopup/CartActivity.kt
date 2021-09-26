package com.kipandatopup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kipandatopup.ui.theme.KipandaTopUpTheme
import com.kipandatopup.views.CartView

class CartActivity :ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		setContent {
			KipandaTopUpTheme {
				CartView().CartViewItems()
			}
		}
	}
}