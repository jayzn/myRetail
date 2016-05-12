package com.myretail.controller

import com.myretail.domain.Product;

import grails.converters.JSON

class ProductController {
    def show() {
		if(params.id && Product.exists(params.id)){
			//render ([product : Product.findById(params.id)] as JSON)
			Product product = Product.findById(params.id)
			Map<String, String> serviceResponse = [
				id: product.id,
				sku: product.sku,
				name: product.name,
				category: product.category,
				price: product.price?.price,
				last_updated: product.lastUpdated
				]
			render ( serviceResponse as JSON)
		   }else{
			render "Product not found - Invalid Id"
		   }
		}
}
