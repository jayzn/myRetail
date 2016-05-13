package com.myretail.controller

import com.myretail.domain.Price
import com.myretail.domain.Product
import com.myretail.service.ProductService
import grails.test.spock.IntegrationSpec

class ProductControllerIntegrationSpec extends IntegrationSpec {

	ProductController controller
	ProductService productService
	Product product1
	
    def setup() {
		productService = new ProductService()
		controller = new ProductController(productService : productService)
		product1 = new Product(
			sku: "AEX143",
			category: "baby",
			name: "Stroller",
			price: (new Price(price: 199.99)))
		product1.save(flush: true, validate: false)
		Product product2 = new Product(
			sku : "IOL123",
			name: "Optimus Prime",
			category: "toys",
			price: (new Price(price: 13.37)))
		product2.save(flush: true, validate: false)
		Product product3 = new Product(
			sku: "FRT154",
			category: "baby",
			name: "Pacifier",
			price: (new Price(price: 15.45)))
		product3.save(flush: true, validate: false)
    }

    void "test product by given id is returned when requested"() {
		setup:
		controller.params.id = (String) product1.id
		
		when:
		controller.show()
		
		then:
		controller.response.json
		controller.response.json.sku == "AEX143"
		controller.response.json.category == "baby"
		controller.response.json.name == "Stroller"
		controller.response.json.price == 199.99
		controller.response.json.last_updated == new Date().format("yyyy-MM-dd")
    }
	
	void "test list of all products is returned when productList is requested"() {
		when:
		controller.list()
		
		then:
		controller.response.json
		List<String> skus = controller.response.json.sku.collect()
		skus.contains("AEX143")
		skus.contains("IOL123")
		skus.contains("FRT154")
	}
	
	void "test list of all products by given category is returned when productList is requested by category"() {
		setup:
		controller.params.cat = "baby"
		
		when:
		controller.list()
		
		then:
		controller.response.json
		controller.response.json[0].category == "baby"
		controller.response.json[1].category == "baby"
	}
}
