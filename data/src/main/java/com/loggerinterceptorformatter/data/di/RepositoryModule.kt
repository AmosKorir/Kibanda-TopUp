package com.loggerinterceptorformatter.data.di

import com.kibanda.domain.repositorities.CustomerRepository
import com.kibanda.domain.repositorities.OrderRepository
import com.kibanda.domain.repositorities.ProductRepository
import com.loggerinterceptorformatter.data.repositories.CustomerApiRepository
import com.loggerinterceptorformatter.data.repositories.OrderApiRepository
import com.loggerinterceptorformatter.data.repositories.ProductApiRepository
import org.koin.dsl.module

object RepositoryModule {
	val repositoryModule = module {
		single {
			CustomerApiRepository() as CustomerRepository
		}
		single {
			OrderApiRepository() as OrderRepository
		}
		single {
			ProductApiRepository() as ProductRepository
		}
	}
}