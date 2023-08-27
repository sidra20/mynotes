package com.mynotess21.mynotes.di

import com.mynotess21.core.iService.INoteService
import com.mynotess21.core.iService.IProductService
import com.mynotess21.service.NoteServiceImpl
import com.mynotess21.service.ProductsServiceImpl
import org.koin.dsl.module

val serviceModule = module{
    factory<INoteService> { NoteServiceImpl(get()) }
    factory<IProductService> { ProductsServiceImpl(get()) }
}