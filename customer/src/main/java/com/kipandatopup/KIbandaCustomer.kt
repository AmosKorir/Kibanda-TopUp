package com.kipandatopup

import android.app.Application
import com.kibanda.viewmodels.di.ViewModelModule
import com.loggerinterceptorformatter.data.di.RepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.NONE

class KIbandaCustomer :Application(){
	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger(NONE)
			androidContext(applicationContext)
			modules(
				listOf(
//					ActivityModule.activityModule,
//					ApiModule.module,
					RepositoryModule.repositoryModule,
					ViewModelModule.module
				)
			)
		}
	}
	
}