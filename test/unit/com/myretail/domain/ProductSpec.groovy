package com.myretail.domain

import com.myretail.domain.Product;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends Specification {

  void "test a valid Product object can be created"() {
		setup:
			Product product = new Product(
				sku: "AEX143",
				category: "Toys",
				name: "Stroller")	 
			
		when: "Validate a product creation"
			 Boolean isValid = product.validate()
		then: "is valid"
			isValid
    }
}
