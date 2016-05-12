package com.myretail.controller

import com.myretail.domain.Price
import com.myretail.domain.Product
import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

@TestFor(ProductController)
@Mock([Product, Price])
class ProductControllerSpec extends Specification {

	Product product
	Price price
    def setup() {
		product = new Product(
			sku: "AEX143",
			category: "Toys",
			name: "Stroller",
			price: (new Price(price: 199.99)))
		product.save(flush: true, validate: false)
    }

    void "test show method retrieves product by given id"() {
		setup:
		params.id = product.id
		
		when:
		controller.show()
		
		then:
		response
		response.json?.sku == "AEX143"
		response.json?.category == "Toys"
		response.json?.name == "Stroller"
		response.json?.sku == "AEX143"
		//response.json?.last_updated 
		response.json?.price == 199.99
	}
}

