package com.myretail.controller

import com.myretail.domain.Product;
import com.myretail.service.ProductService

import grails.converters.JSON

class ProductController {
	ProductService productService
	
    def show() {
		if(params.id){
			render (productService.getProductInfoById(params.id) as JSON)
		   } else {
		   	return render(text: [success: false, cause: "Request body is missing required parameters"] as JSON, status: 422)
		   }
		}
	
	def list() {
		if(params.cat){
			render (productService.getProductInfoByCategory(params.cat) as JSON)
		} else {
		   render productService.getAllProductsInfo() as JSON 
		}
	}	
}
