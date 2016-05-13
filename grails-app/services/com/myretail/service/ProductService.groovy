package com.myretail.service

import com.myretail.domain.Product
import grails.transaction.Transactional

class ProductService {

	Map<String, String> getProductInfoById(String id) {
		Product product = getProductById(id)
		return getProductInfo(product)
	}
	
	List<Map<String, String>> getAllProductsInfo() {
		List<Map<String, String>> allProducts = []
		List<Product> products = getAllProducts()
		products.each {
			allProducts << getProductInfo(it)
		}
		return allProducts
	}
	
	List<Map<String, String>> getProductInfoByCategory(String category) {
		List<Map<String, String>> allProducts = []
		List<Product> products = getAllProductsByCategory(category)
		products.each {
			allProducts << getProductInfo(it)
		}
		return allProducts
	}
	
	Product getProductById(String id) {
		Product product
		if(Product.exists(id)) {
			 product = Product.findById(id)
		}
		return product
	}
	
	List<Product> getAllProducts() {
		return Product.list()
	}
	
	List<Product> getAllProductsByCategory(String category) {
		return Product.findAllByCategory(category)
	}
	
	Map<String, String> getProductInfo(Product product) {
		return [
			id: product.id,
			sku: product.sku,
			name: product.name,
			category: product.category,
			price: product.price?.price,
			last_updated: product.lastUpdated?.format("yyyy-MM-dd")
			]
	}
}
