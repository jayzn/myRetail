package com.myretail.controller

import com.myretail.domain.Price
import com.myretail.domain.Product
import com.myretail.service.ProductService
import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

@TestFor(ProductController)
@Mock([Product, Price])
class ProductControllerSpec extends Specification {
	ProductService productService 
	Product product1
	Product product2
	
    def setup() {
		productService = Mock(ProductService)
		controller.productService = productService
		product1 = new Product(
			sku: "AEX143",
			category: "baby",
			name: "Stroller",
			price: (new Price(price: 199.99)))
		product1.save(flush: true, validate: false)
		product2 = new Product(
			sku : "IOL123",
			name: "Optimus Prime",
			category: "toys",
			price: (new Price(price: 13.37)))
		product2.save(flush: true, validate: false)
    }

    void "validate show method retrieves product by given id"() {
		setup:
		params.id = (String) product1.id
		
		when:
		controller.show()
		
		then: "ProductService is called once"
		1 * productService.getProductInfoById(params.id) >> [sku: "AEX143", category: "baby", name: "Stroller", price: 199.99 ]
		0 * _
		
		and: "JSON response is returned"
		response.json
		response.json.sku == "AEX143"
		response.json.category == "baby"
		response.json.name == "Stroller"
		response.json.price == 199.99
	}
	
	void "test the show method returns an error response when the parameters are incorrect"() {
		when:
		controller.show()
		
		then:
		response.status == 422
	}
	
	void "verify that a list of all products is returned as a JSON when productList is requested" (){		
		when:
		controller.list()
		
		then: "ProductService is called once"
		1 * productService.getAllProductsInfo() >> [[sku: "AEX143", category: "baby", name: "Stroller"],
													[sku: "IOL123", category: "Toys", name: "Optimus Prime"]]
		
		and: "JSON response is returned"
		response.json
		response.json[0].sku == "AEX143"
		response.json[1].sku == "IOL123"
	}
	
	void "test that list of all products by the given category is returned as a JSON" (){
		setup:
		params.cat = "baby"
		
		when:
		controller.list()
		
		then: "ProductService is called once"
		1 * productService.getProductInfoByCategory("baby") >> [[sku: "IOL123", category: "Toys", name: "Optimus Prime"]]
		
		and: "JSON response is returned"
		response.json
		response.json[0].sku == "IOL123"
	}	
}

