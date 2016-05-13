package com.myretail.domain

import com.myretail.domain.Product;

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(Product)
class ProductSpec extends Specification {

  void "test a valid Product object can be created"() {
		setup:
			Product product = new Product(
				sku: "AEX143",
				category: "Toys",
				name: "Stroller",
				price: new Price(price : 199.99)
				)	 
			
		when: "all required attributes are set"
			 Boolean isValid = product.validate()
		then: "product is valid"
			isValid
    }
}
