package com.kibanda.viewmodels.di

import com.kibanda.viewmodels.CustomerViewModel
import com.kibanda.viewmodels.OrderViewModel
import com.kibanda.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

object ViewModelModule {
	val module = org.koin.dsl.module {
		viewModel {
			CustomerViewModel(get())
		}
		
		viewModel {
			OrderViewModel(get())
		}
		viewModel {
			ProductViewModel(get())
		}
	}
}