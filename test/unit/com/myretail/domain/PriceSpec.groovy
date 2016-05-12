package com.myretail.domain

import com.myretail.domain.Price;
import com.myretail.domain.Product;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Price)
class PriceSpec extends Specification {

    void "test a valid Price object can be created"() {
		setup:
			Product product = new Product(
				sku: "AEX143",
				category: "Toys",
				name: "Stroller")
				 
			Price price = new Price(
				product: product,
				price: 199.99)
		when: "Validate a price creation"
			 Boolean isValid = price.validate()
		then: "is valid"
			isValid
    }
}
